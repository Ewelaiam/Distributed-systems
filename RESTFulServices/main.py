import secrets

from fastapi import FastAPI, status, Request, Form, Depends
from fastapi.responses import HTMLResponse
from fastapi.templating import Jinja2Templates
from passlib.context import CryptContext

from background import *
import asyncio

from fastapi.middleware.cors import CORSMiddleware
from starlette.exceptions import HTTPException
from fastapi.exceptions import RequestValidationError

from fastapi.security import HTTPBasic, HTTPBasicCredentials

app = FastAPI()

app.add_middleware(
    CORSMiddleware,
    allow_origins=['*'],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

templates = Jinja2Templates(directory="templates")
security = HTTPBasic()
validation_key = ["x12YZ!"]
pwd_context = CryptContext(schemes=["bcrypt"], deprecated="auto")

def verify_password(plain_password, hashed_password):
    return pwd_context.verify(plain_password, hashed_password)


def get_password_hash(password):
    return pwd_context.hash(password)


def get_current_username(
    credentials: HTTPBasicCredentials = Depends(security)
):
    current_username_bytes = credentials.username.encode("utf8")
    correct_username_bytes = b"secretname"
    is_correct_username = secrets.compare_digest(
        current_username_bytes, correct_username_bytes
    )
    current_password = credentials.password

    correct_password = "$2b$12$VVVqubGnm0D7ugTNF6CCN.Ni7TBD4j1CTrfWelZYZboZAXdQ/yYX6"
    is_correct_password = verify_password(current_password, correct_password)

    if not (is_correct_username and is_correct_password):
        raise HTTPException(
            status_code=status.HTTP_401_UNAUTHORIZED,
            detail="Incorrect email or password",
            headers={"WWW-Authenticate": "Basic"},
        )
    return credentials

@app.get("/auth")
async def read_current_user(credentials: HTTPBasicCredentials = Depends(get_current_username)):
    return {"username": credentials.username, "password": credentials.password}

@app.get("/", response_class=HTMLResponse)
def index(request: Request):
    genres, languages = asyncio.run(get_urls_for_dropdown())
    return templates.TemplateResponse("index.html", {'request': request, 'genres': genres, 'languages': languages})


@app.post("/result")
def handle_form(request: Request,
                username: HTTPBasicCredentials = Depends(read_current_user),
                top_n: int = Form(...),
                genre: str = Form(...),
                language: str = Form(...),
                api_key: str = Form(...)):

    if api_key is None:
        raise HTTPException(status_code=401, detail="Api key is not provided")
    if api_key not in validation_key:
        raise HTTPException(status_code=403, detail="Provided incorrect api key")
    top_films = get_top_n_films(top_n, genre, language)

    average = 0
    for_adult = 0
    release_this_year = 0
    with_video = 0
    is_original_en = 0

    url_title = []
    url_similar = []

    for film in top_films:
        average += film['vote_count']
        for_adult += film['adult']
        url_title.append(film['original_title'])
        url_similar.append(film['id'])
        if "2023" in film['release_date']:
            release_this_year += 1
        if film['video']:
            with_video += 1
        if film['original_language'] == "en":
            is_original_en += 1

    asyncio.run(get_urls_info(url_title, url_similar))
    all_books = get_books()
    similar = get_similar_movies()


    average /= top_n
    best_film = get_top_rated()

    return templates.TemplateResponse("result.html", {'request': request,
                                                      "films": top_films,
                                                      "genre": genre,
                                                      "films_no": len(top_films),
                                                      "flag": language,
                                                      "books": all_books,
                                                      "vote_per_film": round(average, 2),
                                                      "for_adult": for_adult,
                                                      "similar": similar,
                                                      "best_film": best_film,
                                                      "release_this_year": release_this_year,
                                                      "with_video": with_video,
                                                      "en_films": f"{round(is_original_en * 100 / len(top_films), 2)}%"
                                                      })

@app.exception_handler(RequestValidationError)
async def validation_error(request: Request, exc: RequestValidationError):
    return templates.TemplateResponse("error.html", {
        "request": request,
        "code": status.HTTP_422_UNPROCESSABLE_ENTITY,
        "msg": ", ".join([f"{error['loc'][1]} - {error['msg']}" for error in exc.errors()])
        })

@app.exception_handler(422)
async def http_exception(request: Request, exc: HTTPException):
    return templates.TemplateResponse("error.html", {
        "request": request,
        "code": exc.status_code,
        "msg": exc.detail
        })

@app.exception_handler(403)
async def http_exception(request: Request, exc: HTTPException):
    return templates.TemplateResponse("error.html", {
        "request": request,
        "code": exc.status_code,
        "msg": exc.detail
        })


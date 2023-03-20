import json
import requests
import asyncio
import aiohttp

from fastapi import HTTPException

THE_MOVIE_DB_KEY = "eda985cf7b941b9e5c9a35dd3adf2cfc"

url1 = "https://api.themoviedb.org/3/discover/movie?" \
      "api_key={}&" \
      "language={}&" \
      "sort_by=popularity.desc&" \
      "include_adult=false&" \
      "include_video=false&" \
      "with_watch_monetization_types=flatrate" \
      "with_genres={}" \
      "page="

url2 = "https://openlibrary.org/search.json?title={}"

url3 = "https://api.themoviedb.org/3/movie/{}/similar?" \
      "api_key={}" \
      "&language=en-US" \
      "&page=1"

url4 = "https://api.themoviedb.org/3/movie/top_rated" \
      "?api_key={}" \
      "&language=en-US" \
      "&page=1"

url5 = "https://api.themoviedb.org/3/genre/tv/list" \
       "?api_key={}" \
       "&language=en-US"

url6 = "https://countrycode.dev/api/domains"

books = []
films = []


def get_tasks(session, titles, movie_ids):
    tasks = []

    for i in range(len(movie_ids)):
        tasks.append(asyncio.create_task(session.get(url2.format(titles[i]), ssl=False)))
        tasks.append(asyncio.create_task(session.get(url3.format(movie_ids[i], THE_MOVIE_DB_KEY), ssl=False)))

    return tasks

async def get_urls_info(titles, movie_ids):
    async with aiohttp.ClientSession() as session:
        tasks = get_tasks(session, titles, movie_ids)

        responses = await asyncio.gather(*tasks)

        for i in range(0, len(titles) + len(movie_ids), 2):
            books.append(await responses[i].json())
            films.append(await responses[i + 1].json())

def get_top_n_films(top_n, genre, language):
    page = 1
    films = []

    while len(films) < top_n:
        the_movie_db_response = requests.get(url1.format(THE_MOVIE_DB_KEY, language, genre))
        if the_movie_db_response.status_code != 200:
            raise HTTPException(status_code=the_movie_db_response.status_code, detail=the_movie_db_response.reason)

        films_from_page = json.loads(the_movie_db_response.text)
        films += films_from_page["results"]

        page += 1

    return films[:top_n]

def get_books():
    global books
    all = []
    for book in books:
        books_docs = book["docs"]

        titles = []
        length = 3 if len(books_docs) > 3 else len(books_docs)
        for i in range(length):
            titles.append(books_docs[i]['title'])
        all.append(titles)

    return all

def get_similar_movies():
    global films
    all = []
    for film in films:
        film_results = film["results"]

        similar_films = []
        length = 3 if len(film_results) > 3 else len(film_results)
        for i in range(length):
            similar_films.append(film_results[i]['title'])
        all.append(similar_films)

    return all


def get_top_rated():
    result = requests.get(url4.format(THE_MOVIE_DB_KEY))
    if result.status_code != 200:
        raise HTTPException(status_code=result.status_code, detail=result.reason)

    best_films = json.loads(result.text)["results"]

    return best_films[0]['title']



async def get_urls_for_dropdown():
    async with aiohttp.ClientSession() as session:
        tasks = [asyncio.create_task(session.get(url5.format(THE_MOVIE_DB_KEY), ssl=False)),
                 asyncio.create_task(session.get(url6, ssl=False))]

        responses = await asyncio.gather(*tasks)

        dropdown = [await responses[0].json(), await responses[1].json()]

        return dropdown[0]["genres"], dropdown[1]




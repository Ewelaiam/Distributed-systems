FROM python:3.10

COPY requirements.txt ./
COPY homework-1.py ./
COPY homework-2.py ./
COPY homework-3.py ./
COPY homework-3b.py ./


RUN python3 -m venv venv
RUN . venv/bin/activate
RUN pip install -r requirements.txt

CMD ["sh", "-c", "python3 homework-1.py && python3 homework-2.py && ray start --head && python3 homework-3.py && python3 homework-3b.py"]

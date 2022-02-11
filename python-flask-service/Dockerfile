# syntax=docker/dockerfile:1
FROM python:3.9.5-slim as base
LABEL stage=base
RUN apt-get update \
&& apt-get install gcc -y \
&& apt-get install curl -y \
&& apt-get install musl-dev -y \
&& apt-get install libpq-dev -y \
&& apt-get clean
COPY . /python-flask-service
WORKDIR /python-flask-service
RUN pip install -r requirements.txt
CMD ["python", "run.py"]
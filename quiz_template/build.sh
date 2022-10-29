#!/usr/bin/env bash

#docker build -t quiz .
#echo
#docker run --privileged -it --rm -v $(pwd):/app quiz
#docker-compose up --no-log-prefix --build quizzes mongodb mongo-seed

docker-compose up -d mongo-db mongo-seed --build
#docker-compose up -d service2
echo "generating quiz..."
docker-compose up quizzes --build --no-log-prefix
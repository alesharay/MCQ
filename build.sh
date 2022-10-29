#!/usr/bin/env bash

docker-compose up -d
docker build -t quizzes --build-arg choice=$1 .
echo
docker run --privileged -it --rm --network=mcq_mcq -v $(pwd):/app quizzes
# docker-compose up --no-log-prefix --build quizzes -d mongodb mongo-seed

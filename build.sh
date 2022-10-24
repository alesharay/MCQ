#!/usr/bin/env bash

docker build -t quizzes --build-arg choice=$1 .
echo
docker run --privileged -it --rm -v $(pwd):/app quizzes
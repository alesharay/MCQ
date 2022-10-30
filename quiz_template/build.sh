#!/usr/bin/env bash

COMPOSE_DOCKER_CLI_BUILD=1 \
DOCKER_BUILDKIT=1 \
BUILDKIT_INLINE_CACHE=1 \
DOCKER_DEFAULT_PLATFORM=linux/amd64 \


CHANGES_MADE=$1

if [[ "$CHANGES_MADE" == ["y"|"yes"] ]]; 
then
  docker buildx create --use
  docker buildx build --push --platform linux/arm64,linux/amd64 --tag alesharay100/quizzes:v1.0 .
  docker-compose -f ../docker-compose.yml up --build
else
  docker-compose -f ../docker-compose.yml up
fi


# EXPERIMENTAL/DEBUGGING

# docker-compose -f ../docker-compose.yml up -d mongodb
# docker build -t quiz .
# echo
# docker run --privileged --name quiz \
#   -it -d --rm \
#   -e MONGO_INITDB_ROOT_USERNAME=admin \
#   -e MONGO_INITDB_ROOT_PASSWORD=admin \
#   -e MONGO_INITDB_DATABASE=MCQ \
#   -e COLLECTION=awsQuestions \
#   -e DATABASE_URI=mongodb://@localhost:27017/MCQ?authSource=admin \
#   -p 8102:8102 \
#   -v $(pwd):/app \
#   --network mcq_mcq \
#   --link quiz-mongodb \
#   quiz

# docker-compose -f ../docker-compose.yml up --build --no-log-prefix
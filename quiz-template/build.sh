#!/usr/bin/env bash

CHANGES_MADE=$1

COMPOSE_DOCKER_CLI_BUILD=1 \
DOCKER_BUILDKIT=1 \
BUILDKIT_INLINE_CACHE=1 \
DOCKER_DEFAULT_PLATFORM=linux/amd64 \

case $CHANGES_MADE in
    y|yes)
      docker buildx create --use
      docker buildx build --push --platform linux/arm64,linux/amd64 --tag alesharay100/quizzes:v2.0 .
      docker-compose -f ../docker-compose.yml up --build
      ;;
    *)
      docker-compose -f ../docker-compose.yml up
      ;;
esac


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
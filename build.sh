#!/usr/bin/env bash


COMPOSE_DOCKER_CLI_BUILD=1 \
DOCKER_BUILDKIT=1 \
BUILDKIT_INLINE_CACHE=1 \
DOCKER_DEFAULT_PLATFORM=linux/amd64 \
docker-compose up -d --build

echo
echo "Waiting for containers to be fully up and running..."
echo


if [[ $OSTYPE == 'linux-gnu' ]]; then
    until [[ "`sudo docker logs mcq_quizzes_1 | grep Local | awk '{ print $1 }'`" == "Local:" ]]; do
        sleep 0.1;
    done;
else
    until [[ "`docker logs mcq-quizzes-1 | grep Local | awk '{ print $1 }'`" == "Local:" ]]; do
        sleep 0.1;
    done;
fi


make --no-print-directory run CHOICE=${RESPONSE}



# EXPERIMENTAL/DEBUGGING

# docker build -t quizzes --build-arg choice=$1 .

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

#!/usr/bin/env bash

cd quiz_template
./gradlew clean build jar -q && \
# clear && \
java -jar build/libs/quiz_template-0.0.1-SNAPSHOT.jar && \
./gradlew clean -q && \
cd ..
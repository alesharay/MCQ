#!/usr/bin/env bash

./gradlew clean build jar -q && \
java -jar build/libs/quiz_template-0.0.1-SNAPSHOT.jar && \
./gradlew clean -q
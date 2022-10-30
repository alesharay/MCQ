#!/usr/bin/env bash

cd aws_cp_mcq
./gradlew clean build jar -q && \
clear && \
java -jar build/libs/aws_cp_mcq-0.0.1-SNAPSHOT.jar & && \
./gradlew clean -q && \
cd ..
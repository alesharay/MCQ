#!/usr/bin/env bash

./mvnw clean compile package -q && \
java -jar target/quiz-template-0.0.1-SNAPSHOT.jar && \
./mvnw clean -q
#!/usr/bin/env bash

cd azure_fundamentals_mcq
mvn -q clean package -DskipTests && \
clear && \
java -jar target/azure_fundamentals_mcq-1.0-SNAPSHOT.jar
mvn -q clean
cd ..
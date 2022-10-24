#!/usr/bin/env bash

cd aws_cp_mcq
mvn -q clean package -DskipTests && \
clear && \
java -jar target/aws_cp_mcq-1.0-SNAPSHOT.jar && \
mvn -q clean
cd ..
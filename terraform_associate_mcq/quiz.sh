#!/usr/bin/env bash

cd terraform_associate_mcq
mvn -q clean package -DskipTests && \
clear && \
java -jar target/terraform_associate_mcq-1.0-SNAPSHOT.jar
cd ..
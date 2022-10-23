#!/usr/bin/env bash

mvn -q clean package -DskipTests && \
clear && \
java -jar target/terraform_associate_mcq-1.0-SNAPSHOT.jar

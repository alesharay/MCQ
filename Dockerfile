FROM ubuntu:22.04
RUN apt update -y ; apt upgrade -y
RUN DEBIAN_FRONTEND=noninteractive apt install -y wget vim make gradle openjdk-18-jdk-headless ca-certificates ca-certificates-java
ADD . /app
WORKDIR /app
ARG choice
ENV RESPONSE $choice
ENTRYPOINT ["make", "--no-print-directory", "run", "CHOICE=${RESPONSE}"]
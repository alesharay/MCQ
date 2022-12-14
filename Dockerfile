FROM ubuntu:22.04

ADD . /app
WORKDIR /app
ARG choice
ENV RESPONSE $choice
ENTRYPOINT ["make", "--no-print-directory", "run", "CHOICE=${RESPONSE}"]
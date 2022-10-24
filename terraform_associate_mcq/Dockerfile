FROM ubuntu:22.04
RUN apt update -y ; apt upgrade -y
RUN DEBIAN_FRONTEND=noninteractive apt install -y wget vim maven openjdk-18-jdk-headless
ADD . /terraform
WORKDIR /terraform
RUN chmod +x quiz.sh
ENTRYPOINT ["./quiz.sh"]
FROM alesharay100/quizzes:v2.0
RUN apt update -y ; apt upgrade -y
# RUN DEBIAN_FRONTEND=noninteractive apt install -y make maven openjdk-18-jdk-headless
EXPOSE 8102
ADD . /quiz
WORKDIR /quiz
RUN chmod +x quiz.sh
ENTRYPOINT ["./quiz.sh"]
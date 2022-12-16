FROM ubuntu:22.04
EXPOSE 8102
ADD . /quiz
WORKDIR /quiz
RUN chmod +x quiz.sh
ENTRYPOINT ["./quiz.sh"]
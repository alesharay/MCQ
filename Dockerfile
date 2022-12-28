FROM alesharay100/quizzes:v2.0
ADD . /app
WORKDIR /app
ARG choice
ENV RESPONSE $choice
ENTRYPOINT ["make", "--no-print-directory", "run", "CHOICE=${RESPONSE}"]
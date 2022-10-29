FROM mongo:5.0
# Will be set through Environment Files
ARG DATABASE_URI
ARG USERNAME
ARG PASSWORD
ARG COLLECTION

ENV DATABASE_URI ${DATABASE_URI}
ENV USERNAME ${USERNAME}
ENV PASSWORD ${PASSWORD}
ENV COLLECTION ${COLLECTION}

COPY Question.json /Questions.json

CMD mongoimport --username ${USERNAME} --password ${PASSWORD} --uri ${DATABASE_URI} --collection ${COLLECTION} --drop --file mongo-seed/Question.json --jsonArray

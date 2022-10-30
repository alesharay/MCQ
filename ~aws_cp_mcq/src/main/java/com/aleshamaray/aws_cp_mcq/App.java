package com.aleshamaray.aws_cp_mcq;

import java.io.IOException;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.aleshamaray.aws_cp_mcq.config.MongoConfig;
import com.aleshamaray.aws_cp_mcq.db.AwsCollection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;


public class App
{

  public static MongoCollection<Document> dbQuestions;

  public static void main( String[] args ) throws IOException {
    InitQuestions initQuestions = new InitQuestions();
    List<Question> questions = initQuestions.getQuestions();
    Exam.run(questions);
  }

  public static void create(String question, String options, String answer, String explanation) {
    Document document = new Document("_id", new ObjectId());
    document.append("question", question);
    document.append("options", options);
    document.append("answer", answer);
    document.append("explanation", explanation);
    dbQuestions.insertOne(document);
  }
}
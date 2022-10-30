package com.aleshamaray.aws_cp_mcq.db;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import lombok.Data;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.aleshamaray.aws_cp_mcq.config.MongoConfig;

@Data
public class AwsCollection {

  public MongoCollection<Document> dbQuestions;

  public AwsCollection() {
    dbQuestions = MongoConfig.config();
  }

  public void create(String question, String options, String answer, String explanation) {
    Document document = new Document("_id", new ObjectId());
    document.append("question", question);
    document.append("options", options);
    document.append("answer", answer);
    document.append("explanation", explanation);
    dbQuestions.insertOne(document);
  }

  public void readAll() {
    FindIterable<Document> all = dbQuestions.find();
    MongoCursor<Document> it = all.iterator();

    while (it.hasNext()) {
      System.out.println(it.next().toJson());
    }
  }
}

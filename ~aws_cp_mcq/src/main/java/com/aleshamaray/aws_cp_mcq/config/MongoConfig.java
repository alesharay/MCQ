package com.aleshamaray.aws_cp_mcq.config;

import com.aleshamaray.aws_cp_mcq.Constants.Constants;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

public class MongoConfig {

  public static MongoCollection<Document> config() {
    String connectionString = System.getenv("mongodbUri");
    
    try (MongoClient mongoClient = MongoClients.create(connectionString)) {        
        MongoDatabase mcq = mongoClient.getDatabase("MCQ");
        return mcq.getCollection(Constants.COLLECTION);
    }
  }  
}

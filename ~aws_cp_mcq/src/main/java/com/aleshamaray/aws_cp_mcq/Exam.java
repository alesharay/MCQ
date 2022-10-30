package com.aleshamaray.aws_cp_mcq;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bson.Document;

import com.aleshamaray.aws_cp_mcq.Constants.Constants;
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
import com.mongodb.client.model.BulkWriteOptions;
import com.mongodb.client.model.InsertOneModel;

import static com.aleshamaray.aws_cp_mcq.Constants.Colors.*;

public class Exam {

  public static MongoCollection<Document> dbQuestions;

  public static void run(List<Question> questions) throws IOException {

    String connectionString = System.getenv("mongodbUri");

    try (MongoClient mongoClient = MongoClients.create(connectionString)) {
      MongoDatabase mcq = mongoClient.getDatabase("MCQ");

      dbQuestions = mcq.getCollection(Constants.COLLECTION);

      if (dbQuestions.countDocuments() == 0) {
        collectionCreate(mcq);
      }

      FindIterable<Document> all = dbQuestions.find();
      MongoCursor<Document> it = all.iterator();

      Gson gson = new GsonBuilder().setPrettyPrinting().create();

    int score = 0;
    Collections.shuffle(questions);
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = createFileWriter();

    System.out.println();
    int index = 1;

    System.out.printf("%s%d Questions Total%s\n\n", ANSI_YELLOW, questions.size(), ANSI_RESET);
    out.write(String.format("\n%d Questions Total\n\n ", questions.size()));

      // for (Question question : questions) {
      while (it.hasNext()) {
        JsonElement je = JsonParser.parseString(it.next().toJson());
        String question = gson.toJson(je.getAsJsonObject().get("question"))
            .replace("\\n", "\n")
            .replace("\"", "")
            .replace("\\u0027", "\'")
            .replace("\\t", "\t");
        String options = gson.toJson(je.getAsJsonObject().get("options"))
            .replace("\\n", "\n")
            .replace("\"", "")
            .replace("\\u0027", "\'")
            .replace("\\t", "\t");
        String answer = gson.toJson(je.getAsJsonObject().get("answer"))
            .replace("\\n", "\n")
            .replace("\"", "")
            .replace("\\u0027", "\'")
            .replace("\\t", "\t");
        String explanation = gson.toJson(je.getAsJsonObject().get("explanation"))
            .replace("\\n", "\n")
            .replace("\"", "")
            .replace("\\u0027", "\'")
            .replace("\\t", "\t");
        String type = gson.toJson(je.getAsJsonObject().get("type"));

        System.out.printf("%s%s", ANSI_BLUE, ANSI_BOLD);
        System.out.printf("\n%d. ", index);
        out.write(String.format("\n%d. ", index));

        // System.out.println(question.getPrompt());
        System.out.println(question);
        // out.write(String.format(question.getPrompt() + "\n"));
        out.write(question + "\n");

        System.out.printf("%s%s", ANSI_RESET, ANSI_UNBOLD);
        // System.out.println(question.getOptions());
        System.out.println(options);
        // out.write(String.format(question.getOptions() + "\n"));
        out.write(options + "\n");

        System.out.print("\n(examples: d | bcd | q) (q to quit)\nSelection (letter(s) only): ");
        out.write("\n(examples: d | bcd | q) (q to quit)\nSelection (letter(s) only): ");

        String response = in.readLine();
        out.write(response + "\n");

        if (response.equalsIgnoreCase("q")) {
          break;
        }

        if (type.equals(Constants.MULTI_ANSWER)) {
          response.chars()
              .sorted()
              // .collect(StringBuilder::new, StringBuilder::appendCodePoint,
              // StringBuilder::append)
              .toString();
          response = String
              .join("");
        }

        System.out.println("Answer: " + response);

        // if (response.equalsIgnoreCase(question.getAnswer())) {
        if (response.equalsIgnoreCase(answer)) {
          score++;
          System.out.printf("%s%s\nCorrect!%s%s\n", ANSI_BOLD, ANSI_GREEN, ANSI_RESET, ANSI_UNBOLD);
          out.write("\nCorrect!\n");
        } else {
          System.out.printf("%s%s\nIncorrect!%s%s Correct answer is %s%s%s\n", ANSI_BOLD, ANSI_RED, ANSI_RESET,
              ANSI_UNBOLD,
              // ANSI_GREEN, question.getAnswer(), ANSI_RESET);
              ANSI_GREEN, answer, ANSI_RESET);
          // out.write(String.format("\nIncorrect! Correct answer is %s\n",
          // question.getAnswer()));
          out.write("\nIncorrect! Correct answer is " + answer + "\n");
        }

        // System.out.println(question.getAnswerExplanation() + "\n");
        System.out.println(explanation + "\n");
        // out.write(String.format(question.getAnswerExplanation() + "\n\n"));
        out.write(String.format(explanation + "\n\n"));

        index++;
        // break;
      }

      float percentScore = score == 0 ? 0 : (((float) score / (float) (index - 1)) * 100);
      System.out.printf("%s%s\n\nFinal Score%s%s: %d correct / %d answered - %s%s%d%%%s%s\n", ANSI_BOLD, ANSI_PURPLE,
          ANSI_UNBOLD, ANSI_RESET,
          score, index - 1, ANSI_PURPLE, ANSI_BOLD, (int) percentScore, ANSI_RESET, ANSI_UNBOLD);
      out.write(
          String.format("\n\nFinal Score: %d correct / %d answered - %d%%\n", score, index - 1, (int) percentScore));

      in.close();
      out.close();
    }
  }

  public static void collectionCreate(MongoDatabase mcq) throws FileNotFoundException, IOException {
    dbQuestions.drop();
    mcq.createCollection(Constants.COLLECTION);
    dbQuestions = mcq.getCollection(Constants.COLLECTION);

    int count = 0;
    int batch = 100;

    List<InsertOneModel<Document>> docs = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader("mongo-seed/Question.json"))) {
      String line;
      while ((line = br.readLine()) != null) {
        docs.add(new InsertOneModel<>(Document.parse(line)));
        count++;
        if (count == batch) {
          dbQuestions.bulkWrite(docs, new BulkWriteOptions().ordered(false));
          docs.clear();
          count = 0;
        }
      }
    }

    if (count > 0) {
      dbQuestions.bulkWrite(docs, new BulkWriteOptions().ordered(false));
    }
  }

  public static BufferedWriter createFileWriter() throws IOException {
    File file = new File("../aws-results.txt");
    if (file.createNewFile()) {
      System.out.println("File created: " + file.getName());
    }
    return new BufferedWriter(new FileWriter(file));
  }
}
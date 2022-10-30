package com.aleshamray.aws_cp_mcq.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("awsQuestions")
public class Question {
  @Id
  private String id = new ObjectId().toString();
  private String type;
  private String question;
  private String options;
  private String answer;
  private String explanation;
}


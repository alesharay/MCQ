package com.aleshamaray.aws_cp_mcq;

import java.io.IOException;
import java.util.List;

public class App
{
  public static void main( String[] args ) throws IOException {
    InitQuestions initQuestions = new InitQuestions();
    List<Question> questions = initQuestions.getQuestions();
    Exam.run(questions);
  }
}
package com.aleshamaray.aws_cp_mcq;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

import com.aleshamaray.aws_cp_mcq.Constants.Constants;

import static com.aleshamaray.aws_cp_mcq.Constants.Colors.*;


public class Exam {

  public static void run(List<Question> questions) throws IOException  {
    int score = 0;
    Collections.shuffle(questions);
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = createFileWriter();

    System.out.println();
    int index = 1;
    for (Question question : questions) {

      System.out.printf("%s%s", ANSI_BLUE, ANSI_BOLD);
      System.out.printf("\n%d. ", index);
      out.write(String.format("\n%d. ", index));

      System.out.println(question.getPrompt());
      out.write(String.format(question.getPrompt() + "\n"));

      System.out.printf("%s%s", ANSI_RESET, ANSI_UNBOLD);
      System.out.println(question.getOptions());
      out.write(String.format(question.getOptions() + "\n"));

      System.out.print("\n(examples: d | bcd | q) (q to quit)\nSelection (letter(s) only): ");
      out.write(String.format("\n(examples: d | bcd | q) (q to quit)\nSelection (letter(s) only): "));

      String response = in.readLine();
      out.write(String.format(response) + "\n");

      if (response.equalsIgnoreCase("q")) { break; }

      if (question.getType().equals(Constants.MULTI_ANSWER)) {
        response = response.chars()
        .sorted()
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
      }

      if (response.equalsIgnoreCase(question.getAnswer())) {
        score++;
        System.out.printf("%s%sCorrect!%s%s\n", ANSI_BOLD, ANSI_GREEN, ANSI_RESET, ANSI_UNBOLD);
        out.write(String.format("Correct!\n"));
      } else {
        System.out.printf("%s%sIncorrect!%s%s Correct answer is %s%s%s\n", ANSI_BOLD, ANSI_RED, ANSI_RESET, ANSI_UNBOLD,
            ANSI_GREEN, question.getAnswer(), ANSI_RESET);
        out.write(String.format("Incorrect! Correct answer is %s\n", question.getAnswer()));
      }

      System.out.println(question.getAnswerExplanation() + "\n");
      out.write(String.format(question.getAnswerExplanation() + "\n\n"));

      index++;
    }

    float percentScore = score == 0 ? 0 : (((float)score / (float)questions.size()) * 100);
    System.out.printf("%s%s\n\nFinal Score%s%s: %d/%d - %s%s%d%%%s%s\n", ANSI_BOLD, ANSI_PURPLE, ANSI_UNBOLD, ANSI_RESET,
        score, questions.size(), ANSI_PURPLE, ANSI_BOLD, (int)percentScore, ANSI_RESET, ANSI_UNBOLD);
    out.write(String.format("\n\nFinal Score: %d/%d - %d%%\n", score, questions.size(), (int)percentScore));

    in.close();
    out.close();
  }

  public static BufferedWriter createFileWriter() throws IOException {
    File file = new File("../aws-results.txt");
    if (file.createNewFile()) { System.out.println("File created: " + file.getName()); }
    return new BufferedWriter(new FileWriter(file));
  }
}
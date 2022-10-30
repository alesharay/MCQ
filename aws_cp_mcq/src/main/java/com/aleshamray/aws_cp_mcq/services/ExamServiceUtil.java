package com.aleshamray.aws_cp_mcq.services;
//package com.aleshamray.quiz_template.services;
//
//import com.aleshamray.quiz_template.constants.Constants;
//import com.aleshamray.quiz_template.domain.Question;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.io.*;
//import java.util.Collections;
//import java.util.List;
//
//import static com.aleshamray.quiz_template.constants.Colors.*;
//
//@NoArgsConstructor
//@Data
//@Component
//public class ExamServiceUtil implements CommandLineRunner {
//
//  private static QuestionService questionService;
//  private static List<Question> questions;
//
//  public static void setQuestionService(QuestionService questionService) {
//    ExamServiceUtil.questionService = questionService;
//  }
//
//  @Override
//  public  void run(String[] args) throws IOException {
//    questions = questionService.getAllQuestions();
//
//    int score = 0;
//    Collections.shuffle(questions);
//    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
////    BufferedReader in = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(args).getInputStream()));
//    BufferedWriter out = createFileWriter();
//
//    System.out.println();
//    int index = 1;
//
//    System.out.printf("%s%d Questions Total%s\n\n", ANSI_YELLOW, questions.size(), ANSI_RESET);
//    out.write(String.format("\n%d Questions Total\n\n ", questions.size()));
//
//    for(Question question : questions) {
//      System.out.printf("%s%s", ANSI_BLUE, ANSI_BOLD);
//      System.out.printf("\n%d. ", index);
//      out.write(String.format("\n%d. ", index));
//
//      System.out.println(question.getQuestion());
//      out.write(question.getQuestion() + "\n");
//
//      System.out.printf("%s%s", ANSI_RESET, ANSI_UNBOLD);
//      System.out.println(question.getOptions());
//      out.write(question.getOptions() + "\n");
//
//      System.out.print("\n(examples: d | bcd | q) (q to quit)\nSelection (letter(s) only): ");
//      out.write("\n(examples: d | bcd | q) (q to quit)\nSelection (letter(s) only): ");
//
//      String response = in.readLine();
//      out.write(response + "\n");
//
//      if (response.equalsIgnoreCase("q")) {
//        break;
//      }
//
//      if (question.getType().equals(Constants.MULTI_ANSWER)) {
//        response.chars()
//            .sorted()
//            .toString();
//        response = String
//            .join("");
//      }
//
//      System.out.println("Answer: " + response);
//
//      if (response.equalsIgnoreCase(question.getAnswer())) {
//        score++;
//        System.out.printf("%s%s\nCorrect!%s%s\n", ANSI_BOLD, ANSI_GREEN, ANSI_RESET, ANSI_UNBOLD);
//        out.write("\nCorrect!\n");
//      } else {
//        System.out.printf("%s%s\nIncorrect!%s%s Correct answer is %s%s%s\n", ANSI_BOLD, ANSI_RED, ANSI_RESET,
//            ANSI_UNBOLD,
//            ANSI_GREEN, question.getAnswer(), ANSI_RESET);
//        out.write("\nIncorrect! Correct answer is " + question.getAnswer() + "\n");
//      }
//
//      System.out.println(question.getExplanation() + "\n");
//      out.write(String.format(question.getExplanation() + "\n\n"));
//
//      index++;
//    }
//
//    float percentScore = score == 0 ? 0 : (((float) score / (float) (index - 1)) * 100);
//    System.out.printf("%s%s\n\nFinal Score%s%s: %d correct / %d answered - %s%s%d%%%s%s\n", ANSI_BOLD, ANSI_PURPLE,
//        ANSI_UNBOLD, ANSI_RESET,
//        score, index - 1, ANSI_PURPLE, ANSI_BOLD, (int) percentScore, ANSI_RESET, ANSI_UNBOLD);
//    out.write(
//        String.format("\n\nFinal Score: %d correct / %d answered - %d%%\n", score, index - 1, (int) percentScore));
//
//    in.close();
//    out.close();
//  }
//
//  public static BufferedWriter createFileWriter() throws IOException {
//    File file = new File("../aws-results.txt");
//    if (file.createNewFile()) {
//      System.out.println("File created: " + file.getName());
//    }
//    return new BufferedWriter(new FileWriter(file));
//  }
//}

package com.aleshamaray.aws_cp_mcq;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

// TODO: Use a database for this info
@Data
public class InitQuestions {

  private List<Question> questions;

  public InitQuestions() {

    questions = new ArrayList<>();

    String q1 = """
        A company is planning to run a global marketing application in the AWS Cloud. The application will feature videos that can be viewed by users. The company must ensure that all users can view these videos with low latency.
        Which AWS service should the company use to meet this requirement? """;
    // String q1Options = "\tA. True\n\tB. False";
    String q1Options = """
        \tA. AWS Auto Scaling
        \tB. Amazon Kinesis Video Stream
        \tC. Elastic Load Balancing
        \tD. Amazon Cloud Front """;
    String q1Explanation = "Reference: https://aws.amazon.com/cloudfront/ ";
    questions.add(new Question("Multiple Choice", q1, q1Options, "D", q1Explanation));
    // ----------------------------------------------------------------------------------------------------------------------
    String q2 = """
        Which pillar of AWS Well-Architectured Framework referfs to the ability of a system to recover from infrastructure or service disruptions and dynamically acquire computing resources to meet demand? """;
    // String q2Options = "\tA. True\n\tB. False";
    String q2Options = """
        \tA. Security
        \tB. Reliability
        \tC. Performance Efficiency
        \tD. Cost Optimization """;
    String q2Explanation = "Reference: https://aws.amazon.com/architecture/well-architected/ ";
    questions.add(new Question("Multiple Choice", q2, q2Options, "B", q2Explanation));
    // ----------------------------------------------------------------------------------------------------------------------

  }
}

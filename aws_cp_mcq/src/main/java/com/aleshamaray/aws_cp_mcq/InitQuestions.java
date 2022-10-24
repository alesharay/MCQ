package com.aleshamaray.aws_cp_mcq;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import com.aleshamaray.aws_cp_mcq.Constants.Constants;

// TODO: Use a database for this info
@Data
public class InitQuestions {

  private List<Question> questions;

  public InitQuestions() {

    questions = new ArrayList<>();

    String q1 = """
        A company is planning to run a global marketing application in the AWS Cloud. The application will feature videos that can be viewed by users. The company must ensure that all users can view these videos with low latency.
        Which AWS service should the company use to meet this requirement? """;
    String q1Options = """
        \tA. AWS Auto Scaling
        \tB. Amazon Kinesis Video Stream
        \tC. Elastic Load Balancing
        \tD. Amazon Cloud Front """;
    String q1Explanation = "Reference: https://aws.amazon.com/cloudfront/ ";
    questions.add(new Question(Constants.MULTI_CHOICE, q1, q1Options, "D", q1Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q2 = """
        Which pillar of AWS Well-Architected Framework referfs to the ability of a system to recover from infrastructure or service disruptions and dynamically acquire computing resources to meet demand? """;
    String q2Options = """
        \tA. Security
        \tB. Reliability
        \tC. Performance Efficiency
        \tD. Cost Optimization """;
    String q2Explanation = "Reference: https://aws.amazon.com/architecture/well-architected/ ";
    questions.add(new Question(Constants.MULTI_CHOICE, q2, q2Options, "B", q2Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q3 = "Which of the following are benefits to migrating to AWS Cloud? [Choose Two]";
    String q3Options = """
        \tA. Operational resiliance
        \tB. Discounts for products on Amazon.com
        \tC. Business agility
        \tD. Business excellence 
        \tE. Increased staff retention """;
    String q3Explanation = "Reference: https://www.easydeploy.io/blog/benefits-of-aws-migration/ ";
    questions.add(new Question(Constants.MULTI_ANSWER, q3, q3Options, "AC", q3Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q4 = """
      A company is planning to replace its physical on-premises compute servers with AWS serverless compute services. The company wants to be able to take advantage of advanced technologies quickly after the migration.
      Which pillar of the AWS Well-Architected Framework does this plan represent? """;
    String q4Options = """
        \tA. Security
        \tB. Performance efficiency
        \tC. Operational excellence
        \tD. Reliability """;
    String q4Explanation = "Reference: https://aws.amazon.com/architecture/well-architected/ ";
    questions.add(new Question(Constants.MULTI_CHOICE, q4, q4Options, "B", q4Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q5 = """
      A large company has multiple departments. Each department has its own AWS account. Each department has purchased Amazon EC2 Reserved Instances. Some departments do not use all the Reserved Instances that they purchased, and other departments need more Reserved Instances than they purchased. The company needs to manage the AWS accounts for all the departments so that the departments can share the Reserved Instances.
      Which AWS service or tool should the company use to meet these requirements?""";
    String q5Options = """
        \tA. AWS Systems Manager
        \tB. Cost Explorer
        \tC. AWS Trusted Advisor
        \tD. AWS Organizations """;
    String q5Explanation = "Reference: https://aws.amazon.com/organizations/ ";
    questions.add(new Question(Constants.MULTI_CHOICE, q5, q5Options, "D", q5Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q6 = """
      Which component of the AWS global infrastructure is made up of one or more discrete data centers that have redundant power, networking, and connectivity? """;
    String q6Options = """
        \tA. AWS Region
        \tB. Availability Zone
        \tC. Edge Locations
        \tD. AWS Outposts """;
    String q6Explanation = "Reference: https://docs.aws.amazon.com/whitepapers/latest/aws-overview/global-infrastructure ";
    questions.add(new Question(Constants.MULTI_CHOICE, q6, q6Options, "B", q6Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q7 = """
      Which duties are the responsibility of a company that is using AWS Lambda? (Choose two.) """;
    String q7Options = """
        \tA. Security inside of code
        \tB. Selection of CPU resources
        \tC. Patching of operating system
        \tD. Writing and updating code
        \tE. Security of underlying infrastructure """;
    String q7Explanation = "Reference: https://aws.amazon.com/lambda/features/ ";
    questions.add(new Question(Constants.MULTI_ANSWER, q7, q7Options, "AD", q7Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q8 = """
      Which AWS services or features provide disaster recovery solutions for Amazon EC2 instances? [Choose Two] """;
    String q8Options = """
        \tA. EC2 Reserved Instances
        \tB. EC2 Amazon Machine Images (AMIs)
        \tC. Amazon Elastic Block Store (Amazon EBS) snapshots
        \tD. AWS Shield 
        \tE. Amazon GuardDuty """;
    String q8Explanation = "Reference: https://docs.aws.amazon.com/whitepapers/latest/disaster-recovery-workloads-on-aws/disaster-recovery-options-in-the-cloud";
    questions.add(new Question(Constants.MULTI_ANSWER, q8, q8Options, "BC", q8Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q9 = """
      A company is migrating to the AWS Cloud instead of running its infrastructure on premises.
      Which of the following are advantages of this migration? [Choose Two] """;
    String q9Options = """
        \tA. Elimination of the need to perform security auditing
        \tB. Increased global reach and agility
        \tC. Ability to deploy globally in minutes
        \tD. Redundancy by default for all compute services """;
    String q9Explanation = "Reference: https://docs.aws.amazon.com/whitepapers/latest/aws-overview/six-advantages-of-cloud-computing ";
    questions.add(new Question(Constants.MULTI_ANSWER, q9, q9Options, "BC", q9Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q10 = """
        A user is comparing purchase options for an application that runs on Amazon EC2 and Amazon RDS. The application cannot sustain any interruption. The application experiences a predictable amount of usage including some seasonal spikes that last only a few weeks at a time. It is not possible to modify the application.
        Which purchase option meets these requirements MOST cost-effectively? """;
    String q10Options = """
        \tA. 
        \tB. 
        \tC. 
        \tD. """;
    String q10Explanation = "Reference: ";
    questions.add(new Question(Constants.MULTI_CHOICE, q10, q10Options, "", q10Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    // String q3 = """
    //   """;
    // String q3Options = """
    //     \tA. 
    //     \tB. 
    //     \tC. 
    //     \tD. """;
    // String q3Options = "\tA. True\n\tB. False";
    // String q3Explanation = "Reference: ";
    // questions.add(new Question(Constants.MULTI_CHOICE, q3, q3Options, "", q3Explanation));
// // ----------------------------------------------------------------------------------------------------------------------

  }
}

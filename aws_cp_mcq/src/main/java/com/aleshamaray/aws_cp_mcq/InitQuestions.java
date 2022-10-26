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
        \tA. Review the AWS Marketplace and buy Partial Upfront Reserved Instances to cover the predicted and seasonal load.
        \tB. Buy Reserved Instances for the predicted amount of usage throughout the year. Allow any seasonal usage to run on Spot Instances.
        \tC. Buy Reserved Instances for the predicted amount of usage throughout the year. Allow any seasonal usage to run at an On-Demand rate.
        \tD. Buy Reserved Instances to cover all potential usage that results from the seasonal usage. """;
    String q10Explanation = "Reference: https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-spot-instances ";
    questions.add(new Question(Constants.MULTI_CHOICE, q10, q10Options, "C", q10Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q11 = """
      A company wants to review its monthly costs of using Amazon EC2 and Amazon RDS for the past year.
      Which AWS service or tool provides this information? """;
    String q11Options = """
      \tA. AWS Trusted Advisor
      \tB. Cost Explorer
      \tC. Amazon Forecast
      \tD. Amazon CloudWatch """;
    String q11Explanation = "Reference: https://aws.amazon.com/aws-cost-management/aws-cost-explorer ";
    questions.add(new Question(Constants.MULTI_CHOICE, q11, q11Options, "B", q11Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q12 = """
      A company wants to migrate a critical application to AWS. The application has a short runtime. The application is invoked by changes in data or by shifts in system state. The company need a compute solution that maximizes operational efficiency and minimizes the cost of running the application.
      Which AWS solution should the company use to meet these requirements? """;
    String q12Options = """
        \tA. Amazon EC2 On-Demand Instances
        \tB. AWS Lambda
        \tC. Amazon EC2 Reserved Instances
        \tD. Amazon EC2 Spot Instances """;
    String q12Explanation = "Reference: https://aws.amazon.com/lambda/features/ ";
    questions.add(new Question(Constants.MULTI_CHOICE, q12, q12Options, "B", q12Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q13 = """
      Which AWS service or feature allows users to connect with and deploy AWS services programmatically? """;
    String q13Options = """
        \tA. AWS Management Console
        \tB. AWS Cloud9
        \tC. AWS CodePipeline
        \tD. AWS software development kits (SDKs) """;
    String q13Explanation = "Reference: https://aws.amazon.com/developer/tools/ ";
    questions.add(new Question(Constants.MULTI_CHOICE, q13, q13Options, "D", q13Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q14 = """
      A company plans to create a data lake that uses Amazon S3.
      Which factor will have the MOST effect on cost? """;
    String q14Options = """
        \tA. The selection of S3 storage tiers
        \tB. Charges to transfer existing data into Amazon S3
        \tC. The addition of S3 bucket policies
        \tD. S3 ingest fees for each request """;
    String q14Explanation = "Reference: https://docs.aws.amazon.com/s3/index ";
    questions.add(new Question(Constants.MULTI_CHOICE, q14, q14Options, "A", q14Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q15 = """
      A company is launching an ecommerce application that must always be available. The application will run on Amazon EC2 instances continuously for the next 12 months.
      What is the MOST cost-effective instance purchasing option that meets these requirements? """;
    String q15Options = """
        \tA. Spot Instances
        \tB. Savings Plans
        \tC. Dedicated Hosts
        \tD. On-Demand Instances """;
    String q15Explanation = "Reference: https://aws.amazon.com/ec2/pricing/ ";
    questions.add(new Question(Constants.MULTI_CHOICE, q15, q15Options, "B", q15Explanation));
// ----------------------------------------------------------------------------------------------------------------------
//     String q16 = """
//       """;
//     String q16Options = """
//         \tA.
//         \tB.
//         \tC.
//         \tD. """;
//     String q16Options = "\tT. True\n\tF. False";
//     String q16Explanation = "Reference: ";
//     questions.add(new Question(Constants.MULTI_CHOICE, q16, q16Options, "", q16Explanation));
// // ----------------------------------------------------------------------------------------------------------------------
    // String q3 = """
    //   """;
    // String q3Options = """
    //     \tA.
    //     \tB.
    //     \tC.
    //     \tD. """;
    // String q3Options = "\tT. True\n\tF. False";
    // String q3Explanation = "Reference: ";
    // questions.add(new Question(Constants.MULTI_CHOICE, q3, q3Options, "", q3Explanation));
// // ----------------------------------------------------------------------------------------------------------------------

  }
}

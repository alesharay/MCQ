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
    String q16 = """
      Which AWS service or feature can a company use to determine which business unit is using specific AWS resources? """;
    String q16Options = """
        \tA. Cost allocation tags
        \tB. Key pairs
        \tC. Amazon Inspector
        \tD. AWS Trusted Advisor """;
    String q16Explanation = "Reference: ";
    questions.add(new Question(Constants.MULTI_CHOICE, q16, q16Options, "A", q16Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q17 = """
      A company wants to migrate its workloads to AWS, but it lacks expertise in AWS Cloud computing.Which AWS service or feature will help the company with its migration? """;
    String q17Options = """
        \tA. AWS Trusted Advisor
        \tB. AWS Consulting Partners
        \tC. AWS Artifacts
        \tD. AWS Managed Services """;
    String q17Explanation = "Reference: ";
    questions.add(new Question(Constants.MULTI_CHOICE, q17, q17Options, "D", q17Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q18 = """
      Which AWS service or tool should a company use to centrally request and track service limit increases? """;
    String q18Options = """
        \tA. AWS Config
        \tB. Service Quotas
        \tC. AWS Service Catalog
        \tD. AWS Budgets """;
    String q18Explanation = "Reference: ";
    questions.add(new Question(Constants.MULTI_CHOICE, q18, q18Options, "B", q18Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q19 = """
      Which documentation does AWS Artifact provide? """;
    String q19Options = """
        \tA. Amazon EC2 terms and conditions
        \tB. AWS ISO certifications
        \tC. A history of a company's AWS spending
        \tD. A list of previous-generation Amazon EC2 instance types """;
    String q19Explanation = "Reference: ";
    questions.add(new Question(Constants.MULTI_CHOICE, q19, q19Options, "B", q19Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q20 = """
      Which task requires using AWS account root user credentials? """;
    String q20Options = """
        \tA. Viewing billing information
        \tB. Changing the AWS Support plan
        \tC. Starting and stopping Amazon EC2 instances
        \tD. Opening an AWS Support case """;
    String q20Explanation = "Reference: ";
    questions.add(new Question(Constants.MULTI_CHOICE, q20, q20Options, "B", q20Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q21 = """
      A company needs to simultaneously process hundreds of requests from different users.
      Which combination of AWS services should the company use to build an operationally efficient solution? """;
    String q21Options = """
        \tA. Amazon Simple Queue Service (Amazon SQS) and AWS Lambda
        \tB. AWS Data Pipeline and Amazon EC2
        \tC. Amazon Kinesis and Amazon Athena
        \tD. AWS Amplify and AWS AppSync """;
    String q21Explanation = "Reference: ";
    questions.add(new Question(Constants.MULTI_CHOICE, q21, q21Options, "B", q21Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q22 = """
      What is the scope of a VPC within the AWS network? """;
    String q22Options = """
        \tA. A VPC can span all Availability Zones globally.
        \tB. A VPC must span at least two subnets in each AWS Region.
        \tC. A VPC must span at least two edge locations in each AWS Region.
        \tD. A VPC can span all Availability Zones within an AWS Region. """;
    String q22Explanation = "Reference: ";
    questions.add(new Question(Constants.MULTI_CHOICE, q22, q22Options, "D", q22Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q23 = """
      Which of the following are components of an AWS Site-to-Site VPN connection? [Choose Two] """;
    String q23Options = """
        \tA. AWS Storage Gateway
        \tB. Virtual private gateway
        \tC. NAT gateway
        \tD. Internet gateway """;
    String q23Explanation = "Reference: ";
    questions.add(new Question(Constants.MULTI_ANSWER, q23, q23Options, "BD", q23Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q24 = """
      A company needs to establish a connection between two VPCs. The VPCs are located in two different AWS Regions. The company wants to use the existing infrastructure of the VPCs for this connection.
      Which AWS service or feature can be used to establish this connection?""";
    String q24Options = """
        \tA. AWS Client VPN
        \tB. VPC peering
        \tC. AWS Direct Connect
        \tD. VPC endpoints """;
    String q24Explanation = "Reference: https://docs.aws.amazon.com/vpc/latest/peering/what-is-vpc-peering.html ";
    questions.add(new Question(Constants.MULTI_CHOICE, q24, q24Options, "B", q24Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q25 = """
      According to the AWS shared responsibility model, what responsibility does a customer have when using Amazon RDS to host a database? """;
    String q25Options = """
        \tA. Manage connections to the database
        \tB. Install Microsoft SQL Server
        \tC. Design encryption-at-rest strategies
        \tD. Apply minor database patches """;
    String q25Explanation = "Reference: ";
    questions.add(new Question(Constants.MULTI_CHOICE, q25, q25Options, "A", q25Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q26 = """
      What are some advantages of using Amazon EC2 instances to host applications in the AWS Cloud instead of on premises? [Choose Two] """;
    String q26Options = """
        \tA. EC2 includes operating system patch management.
        \tB. EC2 integrates with Amazon VPC, AWS CloudTrail, and AWS Identity and Access Management (IAM).
        \tC. EC2 has a 100% service level agreement (SLA).
        \tD. EC2 has a flexible, pay-as-you-go pricing model.
        \tE. EC2 has automatic storage cost optimization. """;
    String q26Explanation = "Reference: ";
    questions.add(new Question(Constants.MULTI_ANSWER, q26, q26Options, "DE", q26Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q27 = """
      A user needs to determine whether an Amazon EC2 instance's security groups were modified in the last month.
      How can the user see if a change was made?""";
    String q27Options = """
        \tA. Use Amazon EC2 to see if the security group was changed.
        \tB. Use AWS Identity and Access Management (IAM) to see which user or role changed the security group.
        \tC. Use AWS CloudTrail to see if the security group was changed.
        \tD. Use Amazon CloudWatch to see if the security group was changed. """;
    String q27Explanation = "Reference: ";
    questions.add(new Question(Constants.MULTI_CHOICE, q27, q27Options, "C", q27Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q28 = """
      Which AWS service will help protect applications running on AWS from DDoS attacks? """;
    String q28Options = """
        \tA. Amazon GuardDuty
        \tB. AWS WAF
        \tC. AWS Shield
        \tD. Amazon Inspector """;
    String q28Explanation = "Reference: ";
    questions.add(new Question(Constants.MULTI_CHOICE, q28, q28Options, "C", q28Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q29 = """
      Which AWS service or feature acts as a firewall for Amazon EC2 instances? """;
    String q29Options = """
        \tA. Network ACL
        \tB. Elastic network interface
        \tC. Amazon VPC
        \tD. Security group """;
    String q29Explanation = "Reference: ";
    questions.add(new Question(Constants.MULTI_CHOICE, q29, q29Options, "D", q29Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q30 = """
      How does the AWS Cloud pricing model differ from the traditional on-premises storage pricing model? """;
    String q30Options = """
        \tA. AWS resources do not incur costs
        \tB. There are no infrastructure operating costs
        \tC. There are no upfront cost commitments
        \tD. There are no software licensing costs """;
    String q30Explanation = "Reference: ";
    questions.add(new Question(Constants.MULTI_CHOICE, q30, q30Options, "B", q30Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q31 = """
      A company has a single Amazon EC2 instance. The company wants to adopt a highly available architecture.
      What can the company do to meet this requirement?""";
    String q31Options = """
        \tA. Scale vertically to a larger EC2 instance size.
        \tB. Scale horizontally across multiple Availability Zones.
        \tC. Purchase an EC2 Dedicated Instance.
        \tD. Change the EC2 instance family to a compute optimized instance. """;
    String q31Explanation = "Reference: ";
    questions.add(new Question(Constants.MULTI_CHOICE, q31, q31Options, "B", q31Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q32 = """
      A company's on-premises application deployment cycle was 3-4 weeks. After migrating to the AWS Cloud, the company can deploy the application in 2-3 days.
      Which benefit has this company experienced by moving to the AWS Cloud?""";
    String q32Options = """
        \tA. Elasticity
        \tB. Flexibility
        \tC. Agility
        \tD. Resilience """;
    String q32Explanation = "Reference: ";
    questions.add(new Question(Constants.MULTI_CHOICE, q32, q32Options, "A", q32Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q33 = """
      Which of the following are included in AWS Enterprise Support? [Choose Two] """;
    String q33Options = """
        \tA. AWS technical account manager (TAM)
        \tB. AWS partner-led support
        \tC. AWS Professional Services
        \tD. Support of third-party software integration to AWS
        \tE. 5-minute response time for critical issues """;
    String q33Explanation = "Reference: ";
    questions.add(new Question(Constants.MULTI_ANSWER, q33, q33Options, "AD", q33Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q34 = """
      A global media company uses AWS Organizations to manage multiple AWS accounts. Which AWS service or feature can the company use to limit the access to AWS services for member accounts """;
    String q34Options = """
        \tA. AWS Identity and Access Management (IAM)
        \tB. Service control policies (SCPs)
        \tC. Organizational units (OUs)
        \tD. Access control lists (ACLs) """;
    String q34Explanation = "Reference: ";
    questions.add(new Question(Constants.MULTI_CHOICE, q34, q34Options, "C", q34Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q35 = """
      A company wants to limit its employees' AWS access to a portfolio of predefined AWS resources.
      Which AWS solution should the company use to meet this requirement? """;
    String q35Options = """
        \tA. AWS Config
        \tB. AWS software development kits (SDKs)
        \tC. AWS Service Catalog
        \tD. AWS AppSync """;
    String q35Explanation = "Reference: ";
    questions.add(new Question(Constants.MULTI_CHOICE, q35, q35Options, "C", q35Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q36 = """
      An online company was running a workload on premises and was struggling to launch new products and features. After migrating the workload to AWS, the company can quickly launch products and features and can scale its infrastructure as required.
      Which AWS Cloud value proposition does this scenario describe?""";
    String q36Options = """
        \tA. Business agility
        \tB. High availability
        \tC. Security
        \tD. Centralized auditing """;
    String q36Explanation = "Reference: ";
    questions.add(new Question(Constants.MULTI_CHOICE, q36, q36Options, "A", q36Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q37 = """
      Which of the following are advantages of the AWS Cloud? [Choose Two] """;
    String q37Options = """
        \tA. AWS management of user-owned infrastructure
        \tB. Ability to quickly change required capacity
        \tC. High economies of scale
        \tD. Increased deployment time to market
        \tE. Increased fixed expenses """;
    String q37Explanation = "Reference: ";
    questions.add(new Question(Constants.MULTI_ANSWER, q37, q37Options, "BC", q37Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q38 = """
      AWS has the ability to achieve lower pay-as-you-go pricing by aggregating usage across hundreds of thousands of users.
      This describes which advantage of the AWS Cloud? """;
    String q38Options = """
        \tA. Launch globally in minutes
        \tB. Increase speed and agility
        \tC. High economies of scale
        \tD. No guessing about compute capacity """;
    String q38Explanation = "Reference: ";
    questions.add(new Question(Constants.MULTI_CHOICE, q38, q38Options, "C", q38Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q39 = """
      A company has a database server that is always running. The company hosts the server on Amazon EC2 instances. The instance sizes are suitable for the workload. The workload will run for 1 year.
      Which EC2 instance purchasing option will meet these requirements MOST cost-effectively? """;
    String q39Options = """
        \tA. Standard Reserved Instances
        \tB. On-Demand Instances
        \tC. Spot Instances
        \tD. Convertible Reserved Instances """;
    String q39Explanation = "Reference: ";
    questions.add(new Question(Constants.MULTI_CHOICE, q39, q39Options, "A", q39Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q40 = """
      A company is developing a mobile app that needs a high-performance NoSQL database.
      Which AWS services could the company use for this database? [Choose Two] """;
    String q40Options = """
        \tA. Amazon Aurora
        \tB. Amazon RDS
        \tC. Amazon Redshift
        \tD. Amazon DocumentDB (with MongoDB compatibility)
        \tE. Amazon DynamoDB """;
    String q40Explanation = "Reference: ";
    questions.add(new Question(Constants.MULTI_ANSWER, q40, q40Options, "DE", q40Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q41 = """
      Which tasks are the responsibility of AWS, according to the AWS shared responsibility model? [Choose Two] """;
    String q41Options = """
        \tA. Patch the Amazon EC2 guest operating system.
        \tB. Upgrade the firmware of the network infrastructure.
        \tC. Apply password rotation for IAM users.
        \tD. Maintain the physical security of edge locations.
        \tE. Maintain least privilege access to the root user account. """;
    String q41Explanation = "Reference: ";
    questions.add(new Question(Constants.MULTI_ANSWER, q41, q41Options, "BD", q41Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q42 = """
      Which of the following are features of network ACLs as they are used in the AWS Cloud? [Choose Two] """;
    String q42Options = """
        \tA. They are stateless.
        \tB. They are stateful.
        \tC. They evaluate all rules before allowing traffic.
        \tD. They process rules in order, starting with the lowest numbered rule, when deciding whether to allow traffic.
        \tE. They operate at the instance level. """;
    String q42Explanation = "Reference: ";
    questions.add(new Question(Constants.MULTI_ANSWER, q42, q42Options, "AD", q42Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q43 = """
      A company has designed its AWS Cloud infrastructure to run its workloads effectively. The company also has protocols in place to continuously improve supporting processes.
      Which pillar of the AWS Well-Architected Framework does this scenario represent? """;
    String q43Options = """
        \tA. Security
        \tB. Performance efficiency
        \tC. Cost optimization
        \tD. Operational excellence """;
    String q43Explanation = "Reference: ";
    questions.add(new Question(Constants.MULTI_CHOICE, q43, q43Options, "D", q43Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q44 = """
      Which AWS service or feature can be used to create a private connection between an on-premises workload and an AWS Cloud workload? """;
    String q44Options = """
        \tA. Amazon Route 53
        \tB. Amazon Macie
        \tC. AWS Direct Connect
        \tD. AWS PrivateLink """;
    String q44Explanation = "Reference: ";
    questions.add(new Question(Constants.MULTI_CHOICE, q44, q44Options, "D", q44Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q45 = """
      A company needs to graphically visualize AWS billing and usage over time. The company also needs information about its AWS monthly costs.
      Which AWS Billing and Cost Management tool provides this data in a graphical format? """;
    String q45Options = """
        \tA. AWS Bills
        \tB. Cost Explorer
        \tC. AWS Cost and Usage Report
        \tD. AWS Budgets """;
    String q45Explanation = "Reference: ";
    questions.add(new Question(Constants.MULTI_CHOICE, q45, q45Options, "B", q45Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q46 = """
      A company wants to run production workloads on AWS. The company needs concierge service, a designated AWS technical account manager (TAM), and technical support that is available 24 hours a day, 7 days a week.
      Which AWS Support plan will meet these requirements?""";
    String q46Options = """
        \tA. AWS Basic Support
        \tB. AWS Enterprise Support
        \tC. AWS Business Support
        \tD. AWS Developer Support """;
    String q46Explanation = "Reference: ";
    questions.add(new Question(Constants.MULTI_CHOICE, q46, q46Options, "B", q46Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q47 = """
      Which architecture design principle describes the need to isolate failures between dependent components in the AWS Cloud? """;
    String q47Options = """
        \tA. Use a monolithic design.
        \tB. Design for automation.
        \tC. Design for single points of failure.
        \tD. Loosely couple components. """;
    String q47Explanation = "Reference: ";
    questions.add(new Question(Constants.MULTI_CHOICE, q47, q47Options, "D", q47Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q48 = """
      Which AWS services are managed database services? [Choose Two] """;
    String q48Options = """
        \tA. Amazon Elastic Block Store (Amazon EBS)
        \tB. Amazon S3
        \tC. Amazon RDS
        \tD. Amazon Elastic File System (Amazon EFS) """;
    String q48Explanation = "Reference: ";
    questions.add(new Question(Constants.MULTI_ANSWER, q48, q48Options, "CE", q48Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q49 = """
      A company is using the AWS Free Tier for several AWS services for an application. What will happen if the Free Tier usage period expires or if the application use exceeds the Free Tier usage limits?""";
    String q49Options = """
        \tA. The company will be charged the standard pay-as-you-go service rates for the usage that exceeds the Free Tier usage.
        \tB. AWS Support will contact the company to set up standard service charges.
        \tC. The company will be charged for the services it consumed during the Free Tier period plus additional charges for service consumption after the Free Tier period.
        \tD. The company's AWS account will be frozen and can be restarted after a payment plan is established. """;
    String q49Explanation = "Reference: ";
    questions.add(new Question(Constants.MULTI_CHOICE, q49, q49Options, "A", q49Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q50 = """
      A company recently deployed an Amazon RDS instance in its VPC. The company needs to implement a stateful firewall to limit traffic to the private corporate network.
      Which AWS service or feature should the company use to limit network traffic directly to its RDS instance?""";
    String q50Options = """
        \tA. Network ACLs
        \tB. Security groups
        \tC. AWS WAF
        \tD. Amazon GuardDuty """;
    String q50Explanation = "Reference: ";
    questions.add(new Question(Constants.MULTI_CHOICE, q50, q50Options, "B", q50Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    // String q3 = """
    //   """;
    // String q3Options = """
    //     \tA.
    //     \tB.
    //     \tC.
    //     \tD. """;
    // String q3ptions = "\tT. True\n\tF. False";
    // String q3Explanation = "Reference: ";
    // questions.add(new Question(Constants.MULTI_CHOICE, q3, q3Options, "", q3Explanation));
// // ----------------------------------------------------------------------------------------------------------------------

  }
}

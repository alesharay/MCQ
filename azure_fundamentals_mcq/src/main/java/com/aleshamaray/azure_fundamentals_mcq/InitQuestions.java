package com.aleshamaray.azure_fundamentals_mcq;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import com.aleshamaray.azure_fundamentals_mcq.Constants.Constants;

// TODO: Use a database for this info
@Data
public class InitQuestions {

  private List<Question> questions;

  public InitQuestions() {

    questions = new ArrayList<>();


    String q1 = """
      Your company intends to subscribe to an Azure support plan. The support plan must allow for new support requests to be opened.
      Which of the following are support plans that will sllow this? [Choose Four] """;;
    String q1Options = """
        \tA. Basic
        \tB. Developer
        \tC. Standard
        \tD. Professional Direct
        \tE. Premier """;
    String q1Explanation = " Reference: https://azure.microsoft.com/en-us/support/plans/ ";
    questions.add(new Question(Constants.MULTI_ANSWER, q1, q1Options, "BCDE", q1Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q2 = """
      Your comany has datacenters in Los Angeles and New York. The company has a Microsoft Azure subscription. You are configuring the two datacenters as geo-clustered sites for site resiliency. You need to recommend an Azure storage redundancy option. You have the following data storage requirements:

      -> Data must be stored on multiple nodes
      -> Data must be stored on nodes in separate geographic locations
      -> Data can be read from the secondary location as well as from the primary location

      Which of the following Azure stored redundancy options should you recommend? """;;
    String q2Options = """
        \tA. Geo-redundant storage
        \tB. Read-only geo-redundant storage
        \tC. Zone-redundant storage
        \tD. Locally redundant storage """;
    String q2Explanation = """
      Reference: https://docs.microsoft.com/en-us/azure/storage/common/storage-redundancy
      Reference: https://docs.microsoft.com/en-us/azure/storage/common/storage-redundancy-grs#read-access-geo-redundant-storage """;
    questions.add(new Question(Constants.MULTI_CHOICE, q2, q2Options, "B", q2Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q3 = """
      Note: The question is included in a number of questions that depicts the identical set-up. However, every question has a distinctive result. Establish if the solution satisfies the requirements.

      Your company's Azure subscription includes a Basic support plan. They would like to request an assessment of an Azure environment's design from Microsoft. This is, however, not supported by the existing plan. You want to make sure that the company subscribes to a support plan that allows this functionality, while keeping expenses to a minimum.
        Solution: You recommend that the company subscribes to the Professional Direct support plan.
      Does the solution meet the goal? """;;
    String q3Options = "\tY. Yes\n\tN. No";
    String q3Explanation = " Reference: https://azure.microsoft.com/en-gb/support-plans ";
    questions.add(new Question(Constants.TRUE_FALSE, q3, q3Options, "N", q3Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q4 = """
      Note: The question is included in a number of questions that depicts the identical set-up However, every question has a distinctive result. Establish if the solution satisfies the requirements.

      You are tasked with deploying Azure virtual machines for your company. You need to make use of the appropriate cloud deployment solution.
        Solution: You should make use of Software as a Service (SaaS).
      Does the solution meet the goal? """;;
    String q4Options = "\tY. Yes\n\tN. No";
    String q4Explanation = " Reference: ";
    questions.add(new Question(Constants.TRUE_FALSE, q4, q4Options, "N", q4Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q5 = """
      Note: The question is included in a number of questions that depicts the identical set-up. However, every question has a distinctive result. Establish if the solution satisfies the requirements.

      You are tasked with deploying Azure virtual machines for your company. You need to make use of the appropriate cloud deployment solution.
        Solution: You should make use of Platform as a Service (PaaS).
      Does the solution meet the goal? """;;
    String q5Options = "\tY. Yes\n\tN. No";
    String q5Explanation = " Reference: ";
    questions.add(new Question(Constants.TRUE_FALSE, q5, q5Options, "N", q5Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q6 = """
      Note: The question is included in a number of questions that depicts the identical set-up. However, every question has a distinctive result. Establish if the solution satisfies the requirements.

      You are tasked with deploying Azure virtual machines for your company. You need to make use of the appropriate cloud deployment solution.
        Solution: You should make use of Infrastructure as a Service (IaaS).
      Does the solution meet the goal? """;;
    String q6Options = "\tY. Yes\n\tN. No";
    String q6Explanation = " Reference: ";
    questions.add(new Question(Constants.TRUE_FALSE, q6, q6Options, "Y", q6Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q7 = """
      Your developers have created 10 web applications that must be host on Azure. You need to determine which Azure web tier plan to host the web apps. The web tier plan must meet the following requirements:

      -> The web apps will use custom domains.
      -> The web apps each require 10 GB of storage.
      -> The web apps must each run in dedicated compute instances.
      -> Load balancing between instances must be included.
      -> Costs must be minimized.

      Which web tier plan should you use? """;;
    String q7Options = """
        \tA. Standard
        \tB. Basic
        \tC. Free
        \tD. Shared """;
    String q7Explanation = " Reference: http://azure.microsoft.com/en-us/pricing/details/websites/ ";
    questions.add(new Question(Constants.MULTI_CHOICE, q7, q7Options, "A", q7Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q8 = """
      Note: The question is included in a number of questions that depicts the identical set-up. However, every question has a distinctive result. Establish if the solution satisfies the requirements.

      You are planning to migrate a company to Azure. Each of the company's numerous divisions will have an administrator in place to manage the Azure resources used by their respective division. You want to make sure that the Azure deployment you employ allows for Azure to be segmented for the divisions, while keeping administrative effort to a minimum.
        Solution: You plan to make use of several Azure Active Directory (Azure AD) directories.
      Does the solution meet the goal? """;;
    String q8Options = "\tY. Yes\n\tN. No";
    String q8Explanation = " Reference: ";
    questions.add(new Question(Constants.TRUE_FALSE, q8, q8Options, "N", q8Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q9 = """
      Your developers have created a portal web app for users in the Miami branch office. The web app will be publicly accessible and used by the Miami users to retrieve customer and product information. The web app is currently running in an on-premises test environment. You plan to host the web app on Azure. You need to determine which Azure web tier plan to host the web app. The web tier plan must meet the following requirements:

      -> The website will use the miami.weyland.com URL.
      -> The website will be deployed to two instances.
      -> SSL support must be included.
      -> The website requires 12 GB of storage.
      -> Costs must be minimized.

      Which web tier plan should you use? """;;
    String q9Options = """
        \tA. Standard
        \tB. Basic
        \tC. Free
        \tD. Shared """;
    String q9Explanation = " Reference: http://azure.microsoft.com/en-us/documentation/articles/azure-subscription-service-limits/ ";
    questions.add(new Question(Constants.MULTI_CHOICE, q9, q9Options, "A", q9Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q10 = """
      Note: The question is included in a number of questions that depicts the identical set-up. However, every question has a distinctive result. Establish if the solution satisfies the requirements.

      Your company is planning to migrate all their virtual machines to an Azure pay-as-you-go subscription. The virtual machines are currently hosted on the Hyper-V hosts in a data center. You are required make sure that the intended Azure solution uses the correct expenditure model.
        Solution: You should recommend the use of the elastic expenditure model.
      Does the solution meet the goal? """;;
    String q10Options = "\tY. Yes\n\tN. No";
    String q10Explanation = " Reference: ";
    questions.add(new Question(Constants.TRUE_FALSE, q10, q10Options, "N", q10Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q11 = """
      Note: The question is included in a number of questions that depicts the identical set-up. However, every question has a distinctive result. Establish if the solution satisfies the requirements.

      Your company is planning to migrate all their virtual machines to an Azure pay-as-you-go subscription. The virtual machines are currently hosted on the Hyper-V hosts in a data center. You are required make sure that the intended Azure solution uses the correct expenditure model.
        Solution: You should recommend the use of the scalable expenditure model.
      Does the solution meet the goal? """;;
    String q11Options = "\tY. Yes\n\tN. No";
    String q11Explanation = " Reference: ";
    questions.add(new Question(Constants.TRUE_FALSE, q11, q11Options, "N", q11Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q12 = """
      Note: The question is included in a number of questions that depicts the identical set-up. However, every question has a distinctive result. Establish if the solution satisfies the requirements.

      Your company is planning to migrate all their virtual machines to an Azure pay-as-you-go subscription. The virtual machines are currently hosted on the Hyper-V hosts in a data center.You are required make sure that the intended Azure solution uses the correct expenditure model.
        Solution: You should recommend the use of the operational expenditure model.
      Does the solution meet the goal? """;;
    String q12Options = "\tY. Yes\n\tN. No";
    String q12Explanation = " Reference: ";
    questions.add(new Question(Constants.TRUE_FALSE, q12, q12Options, "Y", q12Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q13 = """
      Note: The question is included in a number of questions that depicts the identical set-up. However, every question has a distinctive result. Establish if the solution satisfies the requirements.

      You are required to deploy an Artificial Intelligence (AI) solution in Azure. You want to make sure that you are able to build, test, and deploy predictive analytics for the solution.
        Solution: You should make use of Azure Cosmos DB.
      Does the solution meet the goal? """;;
    String q13Options = "\tY. Yes\n\tN. No";
    String q13Explanation = " Reference: ";
    questions.add(new Question(Constants.TRUE_FALSE, q13, q13Options, "N", q13Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q14 = """
      Note: The question is included in a number of questions that depicts the identical set-up. However, every question has a distinctive result. Establish if the solution satisfies the requirements.

      Your company's Active Directory forest includes thousands of user accounts. You have been informed that all network resources will be migrated to Azure. Thereafter, the on-premises data center will be retired. You are required to employ a strategy that reduces the effect on users, once the planned migration has been completed.
        Solution: You plan to sync all the Active Directory user accounts to Azure Active Directory (Azure AD).
      Does the solution meet the goal? """;;
    String q14Options = "\tY. Yes\n\tN. No";
    String q14Explanation = " Reference: ";
    questions.add(new Question(Constants.TRUE_FALSE, q14, q14Options, "Y", q14Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q15 = """
      Note: The question is included in a number of questions that depicts the identical set-up. However, every question has a distinctive result. Establish if the solution satisfies the requirements.

      You are required to deploy an Artificial Intelligence (AI) solution in Azure.
      You want to make sure that you are able to build, test, and deploy predictive analytics for the solution.
        Solution: You should make use of Azure Machine Learning Studio.
      Does the solution meet the goal? """;;
    String q15Options = "\tY. Yes\n\tN. No";
    String q15Explanation = " Reference: ";
    questions.add(new Question(Constants.TRUE_FALSE, q15, q15Options, "Y", q15Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q16 = """
      Note: The question is included in a number of questions that depicts the identical set-up. However, every question has a distinctive result. Establish if the solution satisfies the requirements.

      Your company's infrastructure includes a number of business units that each need a large number of various Azure resources for everyday operation. The resources required by each business unit are identical. You are required to sanction a strategy to create Azure resources automatically.
        Solution: You recommend that the Azure API Management service be included in the strategy.
      Does the solution meet the goal? """;;
    String q16Options = "\tY. Yes\n\tN. No";
    String q16Explanation = " Reference: ";
    questions.add(new Question(Constants.TRUE_FALSE, q16, q16Options, "N", q16Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q17 = """
      Note: The question is included in a number of questions that depicts the identical set-up. However, every question has a distinctive result. Establish if the solution satisfies the requirements.
      
      Your company's infrastructure includes a number of business units that each need a large number of various Azure resources for everyday operation. The resources required by each business unit are identical. You are required to sanction a strategy to create Azure resources automatically.
        Solution: You recommend that management groups be included in the strategy.
      Does the solution meet the goal? """;;
    String q17Options = "\tY. Yes\n\tN. No";
    String q17Explanation = " Reference: ";
    questions.add(new Question(Constants.TRUE_FALSE, q17, q17Options, "N", q17Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q18 = """
      Note: The question is included in a number of questions that depicts the identical set-up. However, every question has a distinctive result. Establish if the solution satisfies the requirements. 
      
      Your company's infrastructure includes a number of business units that each need a large number of various Azure resources for everyday operation. The resources required by each business unit are identical. You are required to sanction a strategy to create Azure resources automatically.
        Solution: You recommend that the Azure Resource Manager templates be included in the strategy.
      Does the solution meet the goal? """;;
    String q18Options = "\tY. Yes\n\tN. No";
    String q18Explanation = " Reference: ";
    questions.add(new Question(Constants.MULTI_CHOICE, q18, q18Options, "Y", q18Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q19 = """
      Note: The question is included in a number of questions that depicts the identical set-up. However, every question has a distinctive result. Establish if the solution satisfies the requirements. 
      
      You are tasked with deploying a critical LOB application, which will be installed on a virtual machine, to Azure. You are informed that the application deployment strategy should allow for a guaranteed availability of 99.99 percent. You need to make sure that the strategy requires as little virtual machines and availability zones as possible.
        Solution: You include two virtual machines and one availability zone in your strategy.
      Does the solution meet the goal? """;;
    String q19Options = "\tY. Yes\n\tN. No";
    String q19Explanation = " Reference: ";
    questions.add(new Question(Constants.TRUE_FALSE, q19, q19Options, "N", q19Explanation));
// ----------------------------------------------------------------------------------------------------------------------
    String q20 = """
      Note: The question is included in a number of questions that depicts the identical set-up. However, every question has a distinctive result. Establish if the solution satisfies the requirements.
      
      You are tasked with deploying a critical LOB application, which will be installed on a virtual machine, to Azure. You are informed that the application deployment strategy should allow for a guaranteed availability of 99.99 percent. You need to make sure that the strategy requires as little virtual machines and availability zones as possible. 
        Solution: You include one virtual machine and two availability zones in your strategy.
      Does the solution meet the goal?""";;
    String q20Options = "\tY. Yes\n\tN. No";
    String q20Explanation = " Reference: ";
    questions.add(new Question(Constants.TRUE_FALSE, q20, q20Options, "N", q20Explanation));
// ----------------------------------------------------------------------------------------------------------------------
//     String q1 = """
//       """;;
//     String q1Options = """
//         \tA.
//         \tB.
//         \tC.
//         \tD. """;
//     String q1Options = "\tT. True\n\tF. False";
//     String q1Explanation = " Reference: ";
//     questions.add(new Question(Constants.MULTI_CHOICE, q1, q1Options, "", q1Explanation));
// // ----------------------------------------------------------------------------------------------------------------------

  }
}

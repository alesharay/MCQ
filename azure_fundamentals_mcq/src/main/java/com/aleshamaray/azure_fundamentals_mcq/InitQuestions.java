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

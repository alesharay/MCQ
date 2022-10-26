package com.aleshamaray.azure_fundamentals_mcq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
  private String type;
  private String prompt;
  private String options;
  private String answer;
  private String answerExplanation;
}

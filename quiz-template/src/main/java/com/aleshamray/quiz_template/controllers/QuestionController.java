package com.aleshamray.quiz_template.controllers;

import java.util.List;
import java.util.Optional;

import com.aleshamray.quiz_template.domain.Question;
import com.aleshamray.quiz_template.services.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1")
public class QuestionController {

  private final Logger log = LoggerFactory.getLogger(getClass());

  QuestionService questionService;

  public QuestionController(QuestionService questionService) {
    this.questionService = questionService;
  }

  @GetMapping(value = "/")
  public List<Question> getAllQuestions() {
    log.info("Getting all questions...");
    return questionService.getAllQuestions();
  }

  @GetMapping(value = "/{questionId}")
  public Optional<Question> getQuestion(@PathVariable String questionId) {
    log.info("Getting question with ID: {}.", questionId);
    return questionService.getOneQuestion(questionId);
  }

  @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
  public Question addNewQuestion(@RequestBody Question question) {
    log.info("Saving question....");
      return questionService.addQuestion(question);
  }
}
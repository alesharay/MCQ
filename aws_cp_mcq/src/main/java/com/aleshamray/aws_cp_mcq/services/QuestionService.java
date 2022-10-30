package com.aleshamray.aws_cp_mcq.services;

import org.springframework.stereotype.Service;

import com.aleshamray.aws_cp_mcq.domain.Question;
import com.aleshamray.aws_cp_mcq.repository.QuestionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

  private final QuestionRepository questionRepository;

  public QuestionService(QuestionRepository questionRepository) {
    this.questionRepository = questionRepository;
  }

  public List<Question> getAllQuestions() {
    return questionRepository.findAll();
  }

  public Optional<Question> getOneQuestion(String questionId) {
    return questionRepository.findById(questionId);
  }

  public Question addQuestion(Question question) {
    return questionRepository.save(question);
  }
}

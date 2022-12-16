package com.aleshamray.quiz_template.services;

import com.aleshamray.quiz_template.domain.Question;
import com.aleshamray.quiz_template.repository.QuestionRepository;
import org.springframework.stereotype.Service;

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

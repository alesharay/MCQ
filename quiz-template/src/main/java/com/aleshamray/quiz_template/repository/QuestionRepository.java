package com.aleshamray.quiz_template.repository;

import com.aleshamray.quiz_template.domain.Question;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
//@Profile("mongodb")
public interface QuestionRepository extends MongoRepository<Question, String> {
  public Question findById();

}

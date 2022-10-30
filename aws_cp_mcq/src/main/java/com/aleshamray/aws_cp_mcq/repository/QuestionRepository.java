package com.aleshamray.aws_cp_mcq.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aleshamray.aws_cp_mcq.domain.Question;

@Repository
//@Profile("mongodb")
public interface QuestionRepository extends MongoRepository<Question, String> {
  public Question findById();

}

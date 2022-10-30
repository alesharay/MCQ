package com.aleshamray.aws_cp_mcq.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@Configuration
@AllArgsConstructor(onConstructor_={@Autowired})
public class MongoConfig {

  private MongoDatabaseFactory mongoDatabaseFactory;
  private MongoMappingContext mongoMappingContext;

  @Bean
  public MappingMongoConverter mappingMongoConverter() {
    DbRefResolver dbRef = new DefaultDbRefResolver(mongoDatabaseFactory);
    MappingMongoConverter mappingMongoConverter = new MappingMongoConverter(dbRef, mongoMappingContext);
    mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
    return mappingMongoConverter;
  }

  @Bean
  MongoTransactionManager transactionManager(MongoDatabaseFactory dbFactory) {
    return new MongoTransactionManager(dbFactory);
  }
}

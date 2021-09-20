package com.blitznihar.restaturants.dbreceipes.configs;

import java.util.Collection;
import java.util.Collections;

import com.blitznihar.restaturants.dbreceipes.constants.ConfigurationConstants;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = ConfigurationConstants.BASEPACKAGES_REPOSITORY_MONGO)
@PropertySource(ConfigurationConstants.CLASSPATH_DATABASE_PROPERTIES)
public class MongoConfig extends AbstractMongoClientConfiguration {

@Value("${mongo.databasename}")
private String databaseName;
@Value("${mongo.connectionstring}")
private String connectionString;

@Override
  protected String getDatabaseName() {
      return databaseName;
  }
  
  @Override
  public MongoClient mongoClient() {
      ConnectionString connectionString 
      = new ConnectionString(this.connectionString);
      
      MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
          .applyConnectionString(connectionString)
          .build();
      
      return MongoClients.create(mongoClientSettings);
  }

  @Override
  public Collection getMappingBasePackages() {
      return Collections.singleton(ConfigurationConstants.COM_BLITZNIHAR_RESTATURANTS_DBRECEIPES);
  }

}

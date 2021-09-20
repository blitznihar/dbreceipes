package com.blitznihar.restaturants.dbreceipes.configs;

import java.util.Collection;
import java.util.Collections;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.blitznihar.restaturants.dbreceipes.repositories.restaurantMongo") 
public class MongoConfig extends AbstractMongoClientConfiguration {
  
  @Override
  protected String getDatabaseName() {
      return "restaurantdb";
  }
  
  @Override
  public MongoClient mongoClient() {
      ConnectionString connectionString 
      = new ConnectionString("mongodb://admin:password@localhost:27017/?authSource=admin&readPreference=primary&ssl=false");
      //= new ConnectionString("mongodb+srv://mongoadmin:i1tUUhLQ9CFgdGtg@cluster0.kg6sb.mongodb.net/sample_restaurants?retryWrites=true&w=majority");
      
      MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
          .applyConnectionString(connectionString)
          .build();
      
      return MongoClients.create(mongoClientSettings);
  }

  @Override
  public Collection getMappingBasePackages() {
      return Collections.singleton("com.blitznihar.restaturants.dbreceipes");
  }

}

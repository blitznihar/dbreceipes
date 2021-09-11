package com.blitznihar.restaturants.dbreceipes.repositories;

import com.blitznihar.restaturants.dbreceipes.entities.RestaurantModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantMongoRepository extends MongoRepository<RestaurantModel, String> {
    
}

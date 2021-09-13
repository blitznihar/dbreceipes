package com.blitznihar.restaturants.dbreceipes.repositories.RestaurantMongo;

import com.blitznihar.restaturants.dbreceipes.entities.nosql.RestaurantModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantMongoRepository extends CrudRepository<RestaurantModel, String> {
    
}

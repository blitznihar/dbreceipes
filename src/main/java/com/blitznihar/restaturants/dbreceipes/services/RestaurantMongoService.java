package com.blitznihar.restaturants.dbreceipes.services;

import java.util.List;

import com.blitznihar.restaturants.dbreceipes.entities.nosql.RestaurantModel;
import com.blitznihar.restaturants.dbreceipes.repositories.RestaurantMongo.RestaurantMongoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

@Service
public class RestaurantMongoService {
    
    @Autowired
    private RestaurantMongoRepository restaurantMongoRepository;

    public List<RestaurantModel> getRestaurantAll()
    {
        Iterable<RestaurantModel> iterableRestaurants =   restaurantMongoRepository.findAll();
        return Streamable.of(iterableRestaurants).toList();
    }

    public int insertRestaurantAll(List<RestaurantModel> restaurantModels) {
        restaurantMongoRepository.saveAll(restaurantModels);
        return restaurantModels.size();
    }

}

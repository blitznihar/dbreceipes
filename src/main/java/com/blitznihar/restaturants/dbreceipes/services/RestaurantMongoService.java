package com.blitznihar.restaturants.dbreceipes.services;

import java.util.List;
import com.blitznihar.restaturants.dbreceipes.entities.RestaurantModel;
import com.blitznihar.restaturants.dbreceipes.repositories.RestaurantMongoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantMongoService {
    
    @Autowired
    private RestaurantMongoRepository restaurantMongoRepository;

    public List<RestaurantModel> getRestaurantAll()
    {
        return  restaurantMongoRepository.findAll();
    }

    public int insertRestaurantAll(List<RestaurantModel> restaurantModels) {
        restaurantMongoRepository.saveAll(restaurantModels);
        return restaurantModels.size();
    }

}

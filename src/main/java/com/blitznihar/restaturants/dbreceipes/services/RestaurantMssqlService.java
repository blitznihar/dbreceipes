package com.blitznihar.restaturants.dbreceipes.services;

import java.util.List;

import com.blitznihar.restaturants.dbreceipes.entities.sql.RestaurantModel;
import com.blitznihar.restaturants.dbreceipes.repositories.RestaurantMssql.RestaurantMssqlRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

@Service
public class RestaurantMssqlService {
    
    @Autowired
    private RestaurantMssqlRepository restaurantMssqlRepository;

    public List<RestaurantModel> getRestaurantAll()
    {
        Iterable<RestaurantModel> iterableRestaurants =   restaurantMssqlRepository.findAll();
        return Streamable.of(iterableRestaurants).toList();
    }

    public int insertRestaurantAll(List<RestaurantModel> restaurantModels) {
        restaurantMssqlRepository.saveAll(restaurantModels);
        return restaurantModels.size();
    }

}

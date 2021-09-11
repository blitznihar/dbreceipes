package com.blitznihar.restaturants.dbreceipes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blitznihar.restaturants.dbreceipes.entities.RestaurantModel;
import com.blitznihar.restaturants.dbreceipes.repositories.RestaurantH2Repository;



@Service
public class RestaurantH2Service {

    @Autowired
    private RestaurantH2Repository restaurantH2Repository;

    public List<RestaurantModel> getRestaurantAll()
    {
        return  restaurantH2Repository.findAll();
    }

	public int insertRestaurantAll(List<RestaurantModel> restaurantModels) {
        restaurantH2Repository.insertRestaurant(restaurantModels);
        return restaurantModels.size();
	}
    
}

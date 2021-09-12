package com.blitznihar.restaturants.dbreceipes.services;

import java.util.List;
import com.blitznihar.restaturants.dbreceipes.entities.RestaurantModel;
import com.blitznihar.restaturants.dbreceipes.repositories.RestaurantMysqlRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

@Service
public class RestaurantMysqlService {
    
    @Autowired
    private RestaurantMysqlRepository restaurantMysqlRepository;

    public List<RestaurantModel> getRestaurantAll()
    {
        Iterable<RestaurantModel> iterableRestaurants =   restaurantMysqlRepository.findAll();
        return Streamable.of(iterableRestaurants).toList();
    }

    public int insertRestaurantAll(List<RestaurantModel> restaurantModels) {
        restaurantMysqlRepository.saveAll(restaurantModels);
        return restaurantModels.size();
    }

}

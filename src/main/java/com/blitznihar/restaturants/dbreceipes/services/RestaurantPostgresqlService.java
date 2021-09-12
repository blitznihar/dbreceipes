package com.blitznihar.restaturants.dbreceipes.services;

import java.util.List;
import com.blitznihar.restaturants.dbreceipes.entities.RestaurantModel;
import com.blitznihar.restaturants.dbreceipes.repositories.RestaurantPostgresqlRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

@Service
public class RestaurantPostgresqlService {
    
    @Autowired
    private RestaurantPostgresqlRepository restaurantPostgresqlRepository;

    public List<RestaurantModel> getRestaurantAll()
    {
        Iterable<RestaurantModel> iterableRestaurants =   restaurantPostgresqlRepository.findAll();
        return Streamable.of(iterableRestaurants).toList();
    }

    public int insertRestaurantAll(List<RestaurantModel> restaurantModels) {
        restaurantPostgresqlRepository.saveAll(restaurantModels);
        return restaurantModels.size();
    }

}

package com.blitznihar.restaturants.dbreceipes.controllers;

import java.util.List;

import com.blitznihar.restaturants.dbreceipes.entities.RestaurantModel;
import com.blitznihar.restaturants.dbreceipes.services.RestaurantMongoService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mongo")
public class RestaurantMongoController {

    @Autowired
    public RestaurantMongoService restaurantMongoService;

    @GetMapping("/restaurant")
    public List<RestaurantModel> getRestaturants(){

        return restaurantMongoService.getRestaurantAll();
    }

    @PostMapping("/restaurant")
    public String insertRestaturants(@RequestBody List<RestaurantModel> restaurantModels){
         return "Records Inserted: "+restaurantMongoService.insertRestaurantAll(restaurantModels);

    }
    
}

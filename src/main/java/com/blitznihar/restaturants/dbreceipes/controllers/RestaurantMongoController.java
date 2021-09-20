package com.blitznihar.restaturants.dbreceipes.controllers;

import java.util.List;

import com.blitznihar.restaturants.dbreceipes.entities.nosql.RestaurantModel;
import com.blitznihar.restaturants.dbreceipes.services.RestaurantMongoService;
import com.blitznihar.restaturants.dbreceipes.constants.ControllerConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ControllerConstants.MONGO)
public class RestaurantMongoController {

    @Autowired
    public RestaurantMongoService restaurantMongoService;

    @GetMapping(ControllerConstants.RESTAURANT)
    public List<RestaurantModel> getRestaturants(){

        return restaurantMongoService.getRestaurantAll();
    }

    @PostMapping(ControllerConstants.RESTAURANT)
    public String insertRestaturants(@RequestBody List<RestaurantModel> restaurantModels){
         return ControllerConstants.RECORDS_INSERTED+restaurantMongoService.insertRestaurantAll(restaurantModels);

    }
    
}

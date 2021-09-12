package com.blitznihar.restaturants.dbreceipes.controllers;

import java.util.List;

import com.blitznihar.restaturants.dbreceipes.entities.RestaurantModel;
import com.blitznihar.restaturants.dbreceipes.services.RestaurantH2Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/h2")
public class RestaurantH2Controller {

    @Autowired
    public RestaurantH2Service restaurantH2Service;

    @GetMapping("/restaurant")
    public List<RestaurantModel> getRestaturants(){

        return restaurantH2Service.getRestaurantAll();
    }

    @PostMapping("/restaurant")
    public String insertRestaturants(@RequestBody List<RestaurantModel> restaurantModels){
         return "Records Inserted: "+restaurantH2Service.insertRestaurantAll(restaurantModels);

    }
    
}

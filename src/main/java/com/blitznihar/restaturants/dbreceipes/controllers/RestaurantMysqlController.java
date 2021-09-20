package com.blitznihar.restaturants.dbreceipes.controllers;

import java.util.List;

import com.blitznihar.restaturants.dbreceipes.constants.ControllerConstants;
import com.blitznihar.restaturants.dbreceipes.entities.sql.RestaurantModel;
import com.blitznihar.restaturants.dbreceipes.services.RestaurantMysqlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ControllerConstants.MYSQL)
public class RestaurantMysqlController {

    @Autowired
    public RestaurantMysqlService restaurantMysqlService;

    @GetMapping(ControllerConstants.RESTAURANT)
    public List<RestaurantModel> getRestaturants(){

        return restaurantMysqlService.getRestaurantAll();
    }

    @PostMapping(ControllerConstants.RESTAURANT)
    public String insertRestaturants(@RequestBody List<RestaurantModel> restaurantModels){
         return ControllerConstants.RECORDS_INSERTED+restaurantMysqlService.insertRestaurantAll(restaurantModels);

    }
    
}

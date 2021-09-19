package com.blitznihar.restaturants.dbreceipes.controllers;

import com.blitznihar.restaturants.dbreceipes.entities.nosql.RestaurantModel;
import com.blitznihar.restaturants.dbreceipes.services.RestaurantMongoService;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@WebMvcTest(RestaurantMongoController.class)
public class RestaurantMongoControllerTest {

    @Autowired
    private RestaurantMongoController restaurantMongoController;
    
    @MockBean
    private RestaurantMongoService restaurantMongoService;

    // @MockBean
    // private RestaurantMongoRepository mockRestaurantMongoRepository;

    @MockBean
    private List<RestaurantModel> mockRestaurantModels;

    @Test
    public void restaurantMongoControllerIsNotNull() throws Exception
    {
        assertThat(restaurantMongoController).isNotNull();
    }

    @Test
    public void getRestaurantMongoControllerSuccess() throws Exception
    {
        //when(mockRestaurantMongoRepository.findAll()).thenReturn(mockRestaurantModels);
        when(restaurantMongoService.getRestaurantAll()).thenReturn(mockRestaurantModels);
        assertEquals(restaurantMongoController.getRestaturants(), mockRestaurantModels);
    }

    @Test
    public void insertRestaurantAll() {
        //when(mockRestaurantMongoRepository.saveAll(mockRestaurantModels)).thenReturn(mockRestaurantModels);
        when(restaurantMongoService.insertRestaurantAll(mockRestaurantModels)).thenReturn(0);
        assertThat(restaurantMongoService.insertRestaurantAll(mockRestaurantModels)).isNotNegative();
    }
    
}
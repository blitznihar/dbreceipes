package com.blitznihar.restaturants.dbreceipes.controllers;

import com.blitznihar.restaturants.dbreceipes.entities.sql.RestaurantModel;
import com.blitznihar.restaturants.dbreceipes.repositories.RestaurantH2.RestaurantH2Repository;
import com.blitznihar.restaturants.dbreceipes.services.RestaurantH2Service;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
//https://thepracticaldeveloper.com/guide-spring-boot-controller-tests/
//https://docs.spring.io/spring-boot/docs/1.5.4.RELEASE/reference/html/boot-features-testing.html

@WebMvcTest(RestaurantH2Controller.class)
public class RestaurantH2ControllerTest {

    @Autowired
    private RestaurantH2Controller restaurantH2Controller;
    
    @MockBean
    private RestaurantH2Service restaurantH2Service;

    @MockBean
    private RestaurantH2Repository mockRestaurantH2Repository;

    @MockBean
    private List<RestaurantModel> mockRestaurantModels;

    @Test
    public void restaurantH2ControllerIsNotNull() throws Exception
    {
        assertThat(restaurantH2Controller).isNotNull();
    }

    @Test
    public void getRestaurantH2ControllerSuccess() throws Exception
    {
        when(mockRestaurantH2Repository.findAll()).thenReturn(mockRestaurantModels);
        when(restaurantH2Service.getRestaurantAll()).thenReturn(mockRestaurantModels);
        assertEquals(restaurantH2Controller.getRestaturants(), mockRestaurantModels);
    }

    @Test
    public void insertRestaurantAll() {
        when(mockRestaurantH2Repository.saveAll(mockRestaurantModels)).thenReturn(mockRestaurantModels);
        when(restaurantH2Service.insertRestaurantAll(mockRestaurantModels)).thenReturn(0);
        assertThat(restaurantH2Service.insertRestaurantAll(mockRestaurantModels)).isNotNegative();
    }
    
}

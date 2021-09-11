package com.blitznihar.restaturants.dbreceipes.services;

import java.util.List;

import com.blitznihar.restaturants.dbreceipes.entities.RestaurantModel;
import com.blitznihar.restaturants.dbreceipes.repositories.RestaurantH2Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class RestaurantH2ServiceTest {
    
    @Autowired
    private RestaurantH2Service restaurantH2Service;

    @MockBean
    private RestaurantH2Repository mockRestaurantH2Repository;

    @MockBean
    private List<RestaurantModel> mockRestaurantModels;

    @Test
    public void restaurantH2RepositoryIsNotNull() throws Exception
    {
        assertThat(restaurantH2Service).isNotNull();
    }

    @Test
    public void getRestaurantRepositorySuccess() throws Exception
    {
        when(mockRestaurantH2Repository.findAll()).thenReturn(mockRestaurantModels);
        assertEquals(restaurantH2Service.getRestaurantAll(), mockRestaurantModels);
    }

    @Test
    public void insertRestaurantAll() {
        when(mockRestaurantH2Repository.insertRestaurant(mockRestaurantModels)).thenReturn("");
        assertThat(restaurantH2Service.insertRestaurantAll(mockRestaurantModels)).isNotNegative();
    }
}

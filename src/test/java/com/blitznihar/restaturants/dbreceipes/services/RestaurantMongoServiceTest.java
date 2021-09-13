package com.blitznihar.restaturants.dbreceipes.services;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.blitznihar.restaturants.dbreceipes.entities.nosql.RestaurantModel;
import com.blitznihar.restaturants.dbreceipes.repositories.RestaurantMongo.RestaurantMongoRepository;



@SpringBootTest
public class RestaurantMongoServiceTest {
    
    @Autowired
    private RestaurantMongoService restaurantMongoService;

    @MockBean
    private RestaurantMongoRepository mockRestaurantMongoRepository;

    @MockBean
    private List<RestaurantModel> mockRestaurantModels;

    @Test
    public void restaurantMongoRepositoryIsNotNull() throws Exception
    {
        assertThat(restaurantMongoService).isNotNull();
    }

    @Test
    public void getRestaurantRepositorySuccess() throws Exception
    {
        when(mockRestaurantMongoRepository.findAll()).thenReturn(mockRestaurantModels);
        assertEquals(restaurantMongoService.getRestaurantAll(), mockRestaurantModels);
    }

    @Test
    public void insertRestaurantAll() {
        when(mockRestaurantMongoRepository.saveAll(mockRestaurantModels)).thenReturn(mockRestaurantModels);
        assertThat(restaurantMongoService.insertRestaurantAll(mockRestaurantModels)).isGreaterThanOrEqualTo(0);
    }
}

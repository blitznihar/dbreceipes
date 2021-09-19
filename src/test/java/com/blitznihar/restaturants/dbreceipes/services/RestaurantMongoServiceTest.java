package com.blitznihar.restaturants.dbreceipes.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.blitznihar.restaturants.dbreceipes.entities.nosql.AddressModel;
import com.blitznihar.restaturants.dbreceipes.entities.nosql.RestaurantModel;
import com.blitznihar.restaturants.dbreceipes.repositories.RestaurantMongo.RestaurantMongoRepository;






@ExtendWith(MockitoExtension.class)
public class RestaurantMongoServiceTest {
    
    @InjectMocks
    private RestaurantMongoService restaurantMongoService;

    @Mock
    private RestaurantMongoRepository mockRestaurantMongoRepository;

    private List<RestaurantModel> mockRestaurantModels(){
        List<RestaurantModel> result = new ArrayList<RestaurantModel>();
        result.add(new RestaurantModel("Wendys","Hamburgers","Brooklyn",new AddressModel("Flatbush Avenue","469","11225")));
        return result;
       }

    @Test
    public void restaurantMongoRepositoryIsNotNull() throws Exception
    {
        assertThat(restaurantMongoService).isNotNull();
    }

    @Test
    public void getRestaurantRepositorySuccess() throws Exception
    {
        when(mockRestaurantMongoRepository.findAll()).thenReturn(mockRestaurantModels());
        assertThat(restaurantMongoService.getRestaurantAll().size()).isNotNegative();
    }

    @Test
    public void insertRestaurantAll() {
        when(mockRestaurantMongoRepository.saveAll(mockRestaurantModels())).thenReturn(mockRestaurantModels());
        assertThat(restaurantMongoService.insertRestaurantAll(mockRestaurantModels())).isNotNegative();
    }
}

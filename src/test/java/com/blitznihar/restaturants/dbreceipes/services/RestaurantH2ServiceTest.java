package com.blitznihar.restaturants.dbreceipes.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.blitznihar.restaturants.dbreceipes.entities.sql.AddressModel;
import com.blitznihar.restaturants.dbreceipes.entities.sql.RestaurantModel;
import com.blitznihar.restaturants.dbreceipes.repositories.RestaurantH2.RestaurantH2Repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;





@ExtendWith(MockitoExtension.class)
public class RestaurantH2ServiceTest {
    
    @InjectMocks
    private RestaurantH2Service restaurantH2Service;

    @Mock
    private RestaurantH2Repository restaurantH2Repository;
    
  
        private List<RestaurantModel> mockRestaurantModels(){
         List<RestaurantModel> result = new ArrayList<RestaurantModel>();
         result.add(new RestaurantModel("Wendys","Hamburgers","Brooklyn",new AddressModel("Flatbush Avenue","469","11225")));
         return result;
    }
    @Test
    public void mockRestaurantH2Repository_isNotNull() throws Exception
    {
        assertThat(restaurantH2Service).isNotNull();
    }

    @Test
    public void getRestaurantRepositorySuccess() throws Exception
    {
        when(restaurantH2Repository.findAll()).thenReturn(mockRestaurantModels());
        assertEquals(restaurantH2Service.getRestaurantAll(), mockRestaurantModels());
    }

    @Test
    public void insertRestaurantAll() {
        
        when(restaurantH2Repository.saveAll(mockRestaurantModels())).thenReturn(mockRestaurantModels());
        assertThat(restaurantH2Service.insertRestaurantAll(mockRestaurantModels())).isNotNegative();
    }

}

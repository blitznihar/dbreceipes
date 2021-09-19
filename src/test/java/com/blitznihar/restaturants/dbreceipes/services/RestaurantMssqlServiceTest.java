package com.blitznihar.restaturants.dbreceipes.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.blitznihar.restaturants.dbreceipes.entities.sql.AddressModel;
import com.blitznihar.restaturants.dbreceipes.entities.sql.RestaurantModel;
import com.blitznihar.restaturants.dbreceipes.repositories.RestaurantMssql.RestaurantMssqlRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;





@ExtendWith(MockitoExtension.class)
public class RestaurantMssqlServiceTest {
    
    @InjectMocks
    private RestaurantMssqlService restaurantMssqlService;

    @Mock
    private RestaurantMssqlRepository restaurantMssqlRepository;
    
  
        private List<RestaurantModel> mockRestaurantModels(){
         List<RestaurantModel> result = new ArrayList<RestaurantModel>();
         result.add(new RestaurantModel("Wendys","Hamburgers","Brooklyn",new AddressModel("Flatbush Avenue","469","11225")));
         return result;
    }
    @Test
    public void mockRestaurantMssqlRepository_isNotNull() throws Exception
    {
        assertThat(restaurantMssqlService).isNotNull();
    }

    @Test
    public void getRestaurantRepositorySuccess() throws Exception
    {
        when(restaurantMssqlRepository.findAll()).thenReturn(mockRestaurantModels());
        assertEquals(restaurantMssqlService.getRestaurantAll(), mockRestaurantModels());
    }

    @Test
    public void insertRestaurantAll() {
        
        when(restaurantMssqlRepository.saveAll(mockRestaurantModels())).thenReturn(mockRestaurantModels());
        assertThat(restaurantMssqlService.insertRestaurantAll(mockRestaurantModels())).isNotNegative();
    }

}

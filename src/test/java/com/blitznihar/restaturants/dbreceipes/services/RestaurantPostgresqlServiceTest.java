package com.blitznihar.restaturants.dbreceipes.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.blitznihar.restaturants.dbreceipes.entities.sql.AddressModel;
import com.blitznihar.restaturants.dbreceipes.entities.sql.RestaurantModel;
import com.blitznihar.restaturants.dbreceipes.repositories.RestaurantPostgresql.RestaurantPostgresqlRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;





@ExtendWith(MockitoExtension.class)
public class RestaurantPostgresqlServiceTest {
    
    @InjectMocks
    private RestaurantPostgresqlService restaurantPostgresqlService;

    @Mock
    private RestaurantPostgresqlRepository restaurantPostgresqlRepository;
    
  
    private List<RestaurantModel> mockRestaurantModels(){
         List<RestaurantModel> result = new ArrayList<RestaurantModel>();
         result.add(new RestaurantModel("Wendys","Hamburgers","Brooklyn",new AddressModel("Flatbush Avenue","469","11225")));
         return result;
        }
    @Test
    public void mockRestaurantPostgresqlRepository_isNotNull() throws Exception
    {
        assertThat(restaurantPostgresqlService).isNotNull();
    }

    @Test
    public void getRestaurantRepositorySuccess() throws Exception
    {
        when(restaurantPostgresqlRepository.findAll()).thenReturn(mockRestaurantModels());
        assertEquals(restaurantPostgresqlService.getRestaurantAll(), mockRestaurantModels());
    }

    @Test
    public void insertRestaurantAll() {
        
        when(restaurantPostgresqlRepository.saveAll(mockRestaurantModels())).thenReturn(mockRestaurantModels());
        assertThat(restaurantPostgresqlService.insertRestaurantAll(mockRestaurantModels())).isNotNegative();
    }

}

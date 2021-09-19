package com.blitznihar.restaturants.dbreceipes.controllers;

import com.blitznihar.restaturants.dbreceipes.entities.sql.AddressModel;
import com.blitznihar.restaturants.dbreceipes.entities.sql.RestaurantModel;
import com.blitznihar.restaturants.dbreceipes.services.RestaurantPostgresqlService;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;



@WebMvcTest(RestaurantPostgresqlController.class)
public class RestaurantPostgresqlControllerTest {

    @Autowired
    private RestaurantPostgresqlController restaurantPostgresqlController;
    
    @MockBean
    private RestaurantPostgresqlService restaurantPostgresqlService;

    @MockBean
    private List<RestaurantModel> mockRestaurantModels;

    private List<RestaurantModel> mockRestaurantModels(){
        List<RestaurantModel> result = new ArrayList<RestaurantModel>();
        result.add(new RestaurantModel("Wendys","Hamburgers","Brooklyn",new AddressModel("Flatbush Avenue","469","11225")));
        return result;
       }
       
    @Autowired
    private MockMvc mockMvc;
        
    @Test
    public void restaurantMongoControllerIsNotNull() throws Exception
    {
        assertThat(restaurantPostgresqlController).isNotNull();
    }

    @Test
    public void getRestaurantMongoControllerSuccess() throws Exception
    {
        //when(mockRestaurantMongoRepository.findAll()).thenReturn(mockRestaurantModels);
        when(restaurantPostgresqlService.getRestaurantAll()).thenReturn(mockRestaurantModels);
        assertEquals(restaurantPostgresqlController.getRestaturants(), mockRestaurantModels);
    }

    @Test
    public void insertRestaurantMongoControllerSuccess() throws Exception
    {
        //when(mockRestaurantMongoRepository.findAll()).thenReturn(mockRestaurantModels);
        when(restaurantPostgresqlService.insertRestaurantAll(mockRestaurantModels)).thenReturn(0);
        assertEquals(restaurantPostgresqlController.insertRestaturants(mockRestaurantModels()), "Records Inserted: 0");
    }
    @Test
    public void get_restaurantMongoController_Success() throws Exception
    {
        when(restaurantPostgresqlService.getRestaurantAll()).thenReturn(mockRestaurantModels());

        mockMvc.perform(MockMvcRequestBuilders.get("/postgresql/restaurant"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(1))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Wendys"))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].cuisine").value("Hamburgers"))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].borough").value("Brooklyn"))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].address.street").value("Flatbush Avenue"))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].address.building").value("469"))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].address.zipcode").value("11225"));
    }

    @Test
    public void insertRestaurantAll() throws Exception {
        //when(mockRestaurantMongoRepository.saveAll(mockRestaurantModels)).thenReturn(mockRestaurantModels);
        when(restaurantPostgresqlService.insertRestaurantAll(mockRestaurantModels)).thenReturn(0);
        mockMvc.perform(MockMvcRequestBuilders.get("/postgresql/restaurant"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
    
}
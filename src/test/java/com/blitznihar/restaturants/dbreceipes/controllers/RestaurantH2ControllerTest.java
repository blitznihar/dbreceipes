package com.blitznihar.restaturants.dbreceipes.controllers;

import com.blitznihar.restaturants.dbreceipes.entities.sql.AddressModel;
import com.blitznihar.restaturants.dbreceipes.entities.sql.RestaurantModel;
import com.blitznihar.restaturants.dbreceipes.repositories.RestaurantH2.RestaurantH2Repository;
import com.blitznihar.restaturants.dbreceipes.services.RestaurantH2Service;

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
//https://thepracticaldeveloper.com/guide-spring-boot-controller-tests/
//https://docs.spring.io/spring-boot/docs/1.5.4.RELEASE/reference/html/boot-features-testing.html

@WebMvcTest(RestaurantH2Controller.class)
public class RestaurantH2ControllerTest {

    @Autowired
    private RestaurantH2Controller restaurantH2Controller;
    
    @MockBean
    private RestaurantH2Service restaurantH2Service;


    private List<RestaurantModel> mockRestaurantModels(){
        List<RestaurantModel> result = new ArrayList<RestaurantModel>();
        result.add(new RestaurantModel("Wendys","Hamburgers","Brooklyn",new AddressModel("Flatbush Avenue","469","11225")));
        return result;
       }
       
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void restaurantH2ControllerIsNotNull() throws Exception
    {
        assertThat(restaurantH2Controller).isNotNull();
    }

    @Test
    public void getRestaurantH2ControllerSuccess() throws Exception
    {
        
        when(restaurantH2Service.getRestaurantAll()).thenReturn(mockRestaurantModels());
        assertEquals(restaurantH2Controller.getRestaturants(), mockRestaurantModels());
    }

    @Test
    public void insertRestaurantAll() {
        
        when(restaurantH2Service.insertRestaurantAll(mockRestaurantModels())).thenReturn(0);
        assertThat(restaurantH2Service.insertRestaurantAll(mockRestaurantModels())).isNotNegative();
    }
    @Test
    public void get_restaurantMongoController_Success() throws Exception
    {
        when(restaurantH2Service.getRestaurantAll()).thenReturn(mockRestaurantModels());

        mockMvc.perform(MockMvcRequestBuilders.get("/h2/restaurant"))
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
    public void insert_RestaurantAll() throws Exception {
        when(restaurantH2Service.insertRestaurantAll(mockRestaurantModels())).thenReturn(0);
        mockMvc.perform(MockMvcRequestBuilders.get("/h2/restaurant"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

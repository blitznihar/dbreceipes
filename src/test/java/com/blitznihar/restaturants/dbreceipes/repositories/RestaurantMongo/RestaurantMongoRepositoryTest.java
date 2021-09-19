package com.blitznihar.restaturants.dbreceipes.repositories.RestaurantMongo;
import com.blitznihar.restaturants.dbreceipes.entities.nosql.AddressModel;
import com.blitznihar.restaturants.dbreceipes.entities.nosql.RestaurantModel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.assertj.core.api.Assertions.assertThat;
//import org.junit.runner.Runwith;

import java.util.ArrayList;
import java.util.List;

//@Runwith(SpringRunner.class)
@DataMongoTest
public class RestaurantMongoRepositoryTest {

@Autowired
private RestaurantMongoRepository mongoRepository;


  @Test
  public void should_find_no_restaurant_if_repository_is_empty() {
    Iterable<RestaurantModel> restaurants = mongoRepository.findAll();

    assertThat(restaurants).isEmpty();
  }

  @Test
  public void should_store_restaurants() throws Exception {

    RestaurantModel restaurantModel = new RestaurantModel("Wendys","Hamburgers","Brooklyn",new AddressModel("Flatbush Avenue","469","11225"));
    RestaurantModel restaurant = mongoRepository.save(restaurantModel);
    assertThat(restaurant).isNotNull();
    assertThat(restaurant).hasFieldOrPropertyWithValue("name","Wendys");
    assertThat(restaurant).hasFieldOrPropertyWithValue("cuisine","Hamburgers");
    assertThat(restaurant).hasFieldOrPropertyWithValue("borough","Brooklyn");
  }
  @Test
  public void should_store_all_restaurants() throws Exception {

    RestaurantModel restaurantModel = new RestaurantModel("Wendys","Hamburgers","Brooklyn",new AddressModel("Flatbush Avenue","469","11225"));
    List<RestaurantModel> restaurantModels = new ArrayList<RestaurantModel>();
    restaurantModels.add(restaurantModel);
    List<RestaurantModel> restaurants =  (List<RestaurantModel>) mongoRepository.saveAll(restaurantModels);
    assertThat(restaurants).isNotNull()
                            .hasSize(1)
                            .contains(restaurantModel);
    assertThat(restaurants.get(0)).hasFieldOrPropertyWithValue("name","Wendys")
                                .hasFieldOrPropertyWithValue("cuisine","Hamburgers")
                                .hasFieldOrPropertyWithValue("borough","Brooklyn");
  }
}

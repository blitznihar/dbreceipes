package com.blitznihar.restaturants.dbreceipes.repositories.RestaurantMysql;

import com.blitznihar.restaturants.dbreceipes.entities.sql.AddressModel;
import com.blitznihar.restaturants.dbreceipes.entities.sql.RestaurantModel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.assertj.core.api.Assertions.assertThat;
//import org.junit.runner.Runwith;

import java.util.ArrayList;
import java.util.List;

//@Runwith(SpringRunner.class)
@DataJpaTest
public class RestaurantMysqlRepositoryTest {

@Autowired
private RestaurantMysqlRepository mysqlRepository;

@Autowired
  private TestEntityManager entityManager;

  @Test
  void test_persistance() throws Exception {
    this.entityManager.persist(new RestaurantModel());
  }
  @Test
  public void should_find_no_restaurant_if_repository_is_empty() {
    Iterable<RestaurantModel> restaurants = mysqlRepository.findAll();

    assertThat(restaurants).isEmpty();
  }

  @Test
  public void should_store_restaurants() throws Exception {

    RestaurantModel restaurantModel = new RestaurantModel("Wendys","Hamburgers","Brooklyn",new AddressModel("Flatbush Avenue","469","11225"));
    RestaurantModel restaurant = mysqlRepository.save(restaurantModel);
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
    List<RestaurantModel> restaurants =  (List<RestaurantModel>) mysqlRepository.saveAll(restaurantModels);
    assertThat(restaurants).isNotNull()
                            .hasSize(1)
                            .contains(restaurantModel);
    assertThat(restaurants.get(0)).hasFieldOrPropertyWithValue("name","Wendys")
                                .hasFieldOrPropertyWithValue("cuisine","Hamburgers")
                                .hasFieldOrPropertyWithValue("borough","Brooklyn");
  }
}

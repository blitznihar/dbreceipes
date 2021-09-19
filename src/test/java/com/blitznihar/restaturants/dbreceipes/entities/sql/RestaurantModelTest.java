package com.blitznihar.restaturants.dbreceipes.entities.sql;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RestaurantModelTest {
    public RestaurantModel createRestaurantModelTestSuite() {
        return new RestaurantModel("Wendys","Hamburgers","Brooklyn",
                new AddressModel("Flatbush Avenue","469","11225")
                );
    }
    public RestaurantModel createEmptyRestaurantModelTestSuite() {
        return new RestaurantModel();
    }
    public RestaurantModel createEmptyAddressModelTestSuite() {
        return new RestaurantModel("Wendys","Hamburgers","Brooklyn",
        new AddressModel()
        );
    }

    @Test
    public void test_get_restaurant_id() throws Exception {
       RestaurantModel restaurantModel = createRestaurantModelTestSuite();
       assertThat(restaurantModel.getName())
                                .isNotNull()
                                .isNotEmpty()
                                .isEqualTo("Wendys");
       assertThat(restaurantModel.getCuisine())
                                .isNotNull()
                                .isNotEmpty()
                                .isEqualTo("Hamburgers");
       assertThat(restaurantModel.getBorough())
                                .isNotNull()
                                .isNotEmpty()
                                .isEqualTo("Brooklyn");

        assertThat(restaurantModel.getAddress().getStreet())
                                .isNotNull()
                                .isNotEmpty()
                                .isEqualTo("Flatbush Avenue");
        assertThat(restaurantModel.getAddress().getBuilding())
                                .isNotNull()
                                .isNotEmpty()
                                .isEqualTo("469");

        assertThat(restaurantModel.getAddress().getZipcode())
                                .isNotNull()
                                .isNotEmpty()
                                .isEqualTo("11225");

    }

    @Test
    public void test_get_empty_restaurant() throws Exception {
        RestaurantModel restaurantModel = createEmptyRestaurantModelTestSuite();
        assertThat(restaurantModel)
                                 .isNotNull();
    }
    @Test
    public void test_get_empty_address() throws Exception {
        RestaurantModel restaurantModel = createEmptyAddressModelTestSuite();
        assertThat(restaurantModel)
                                 .isNotNull();
                                 assertThat(restaurantModel.getAddress())
                                 .isNotNull();
    }

}

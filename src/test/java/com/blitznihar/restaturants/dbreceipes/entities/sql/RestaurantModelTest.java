package com.blitznihar.restaturants.dbreceipes.entities.sql;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RestaurantModelTest {
    public RestaurantModel createRestaurantModelTestSuite() {
        return new RestaurantModel("Wendys","Hamburgers","Brooklyn",
                new AddressModel("Flatbush Avenue","469","11225")
                );
    }

    @Test
    public void test_get_restaurant_id() throws Exception {
       RestaurantModel restaurantModel = createRestaurantModelTestSuite();
       assertThat(restaurantModel.getBorough())
                                .isNotNull()
                                .isNotEmpty()
                                .isEqualTo("Brooklyn");

    }
}

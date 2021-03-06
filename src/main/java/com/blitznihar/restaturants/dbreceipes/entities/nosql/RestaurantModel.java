package com.blitznihar.restaturants.dbreceipes.entities.nosql;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "restaurant")
public class RestaurantModel {

    public RestaurantModel() {
    }
    private String name;
    private String cuisine;
    private String borough;
    private AddressModel address;

    public RestaurantModel(String name, String cuisine, String borough, AddressModel address) {
        this.name = name;
        this.cuisine = cuisine;
        this.borough = borough;
        this.address = address;
    }
}

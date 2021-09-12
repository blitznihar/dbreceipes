package com.blitznihar.restaturants.dbreceipes.entities;

import lombok.Data;

@Data
public class AddressModel {

    public AddressModel() {
    }

private String street;
private String building;
private String zipcode;

    public AddressModel(String street, String building, String zipcode) {
        this.street = street;
        this.building = building;
        this.zipcode = zipcode;
    }
}

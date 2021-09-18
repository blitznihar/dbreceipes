package com.blitznihar.restaturants.dbreceipes.entities.sql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="Address")
public class AddressModel {

    public AddressModel() {
    }
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int addressId;
    private String street;
    private String building;
    private String zipcode;

    public AddressModel(String street, String building, String zipcode) {
        this.street = street;
        this.building = building;
        this.zipcode = zipcode;
    }
}

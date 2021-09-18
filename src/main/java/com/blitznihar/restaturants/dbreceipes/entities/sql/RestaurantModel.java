package com.blitznihar.restaturants.dbreceipes.entities.sql;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "Restaurant")
public class RestaurantModel {

    public RestaurantModel() {
    }
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int restaurantId;
    private String name;
    private String cuisine;
    private String borough;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AddressId")
    private AddressModel address;

    public RestaurantModel(String name, String cuisine, String borough, AddressModel address) {
        this.name = name;
        this.cuisine = cuisine;
        this.borough = borough;
        this.address = address;
    }
}

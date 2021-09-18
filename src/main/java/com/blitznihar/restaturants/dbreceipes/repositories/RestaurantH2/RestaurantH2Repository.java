package com.blitznihar.restaturants.dbreceipes.repositories.RestaurantH2;

import com.blitznihar.restaturants.dbreceipes.entities.sql.RestaurantModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantH2Repository extends JpaRepository<RestaurantModel, String>{
}
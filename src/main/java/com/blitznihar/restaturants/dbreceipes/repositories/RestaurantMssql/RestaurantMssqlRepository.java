package com.blitznihar.restaturants.dbreceipes.repositories.RestaurantMssql;
import com.blitznihar.restaturants.dbreceipes.entities.sql.RestaurantModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantMssqlRepository extends JpaRepository<RestaurantModel, String>{

}
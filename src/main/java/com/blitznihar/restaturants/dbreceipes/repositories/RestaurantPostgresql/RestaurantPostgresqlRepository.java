package com.blitznihar.restaturants.dbreceipes.repositories.RestaurantPostgresql;
import com.blitznihar.restaturants.dbreceipes.entities.sql.RestaurantModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantPostgresqlRepository extends CrudRepository<RestaurantModel, String>{

}
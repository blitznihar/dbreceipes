package com.blitznihar.restaturants.dbreceipes.repositories;
import com.blitznihar.restaturants.dbreceipes.entities.RestaurantModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantMysqlRepository extends CrudRepository<RestaurantModel, String>{

}
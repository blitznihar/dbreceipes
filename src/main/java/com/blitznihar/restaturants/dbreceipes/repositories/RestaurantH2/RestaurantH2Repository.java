package com.blitznihar.restaturants.dbreceipes.repositories.RestaurantH2;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.blitznihar.restaturants.dbreceipes.entities.sql.RestaurantModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantH2Repository extends JpaRepository<RestaurantModel, String>{

    // @Autowired
    // JdbcTemplate jdbcTemplate;
    
    // public List<RestaurantModel> findAll(){

    //     String sql = "SELECT NAME, CUISINE, BOROUGH, STREET, BUILDING, ZIPCODE from RESTAURANT INNER JOIN ADDRESS on RESTAURANT.AddressId=ADDRESS.AddressId";
    //     return jdbcTemplate.query(sql, new RestaurantRowMapper());
    // }

    // public String insertRestaurant(List<RestaurantModel> restaurants){
    //     String sql = "INSERT INTO Address(Street, Building, ZipCode) VALUES (?,?,?);"+
    //     "INSERT INTO Restaurant( Name, Cuisine, Borough, AddressId) VALUES (?,?,?,(SELECT IDENTITY()));";
    //     jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

    //         @Override
    //         public void setValues(PreparedStatement ps, int i) throws SQLException {
    //             AddressModel address = restaurants.get(i).getAddress();
    //             RestaurantModel restaurant = restaurants.get(i);
    //             ps.setObject(1, address.getStreet());
    //             ps.setObject(2, address.getBuilding());
    //             ps.setObject(3, address.getZipcode());
    //             ps.setObject(4, restaurant.getName());
    //             ps.setObject(5, restaurant.getCuisine());
    //             ps.setObject(6, restaurant.getBorough());
    //         }
        
    //         @Override
    //         public int getBatchSize() {
    //             return restaurants.size();
    //         }
    //     });
    //     return "";
    // }
}
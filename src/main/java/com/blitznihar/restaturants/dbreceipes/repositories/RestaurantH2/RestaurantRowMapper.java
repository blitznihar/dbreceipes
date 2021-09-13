package com.blitznihar.restaturants.dbreceipes.repositories.RestaurantH2;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.blitznihar.restaturants.dbreceipes.entities.sql.AddressModel;
import com.blitznihar.restaturants.dbreceipes.entities.sql.RestaurantModel;
public class RestaurantRowMapper implements RowMapper<RestaurantModel>{

    @Override
    public RestaurantModel mapRow(ResultSet rs, int rowNum) throws SQLException {
       
        return new RestaurantModel(rs.getString("name"), rs.getString("cuisine"), rs.getString("borough"),new AddressModel(rs.getString("street"),rs.getString("building"), rs.getString("zipcode")));
    }

}

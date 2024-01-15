package com.soppingWebsite.repository.mapper;

import com.soppingWebsite.model.Address;
import com.soppingWebsite.model.CustomUser;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserMapper implements RowMapper<CustomUser> {

    @Override
    public CustomUser mapRow(ResultSet rs, int rowNum) throws SQLException {

        Address address = new Address(
            rs.getString("city"),
            rs.getString("street"),
            rs.getInt("buildingNumber"),
            rs.getInt("apartment")
        );

        CustomUser customUser = new CustomUser(
            rs.getLong("user_id"),
            rs.getString("first_name"),
            rs.getString("last_name"),
            rs.getString("email"),
            rs.getString("phone"),
            address,
            rs.getString("username"),
            rs.getString("password"),
            rs.getString("roles"),
            rs.getString("permissions")

        );

        return customUser;
    }

}

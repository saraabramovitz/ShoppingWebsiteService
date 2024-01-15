package com.soppingWebsite.repository;

import com.soppingWebsite.model.CustomUser;
import com.soppingWebsite.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepositoryImpl implements UserRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    UserMapper userMapper;

    public static final String USER_TABLE_NAME = "user";
    @Override
    public void createUser(CustomUser customUser) {
        String sql = "INSERT INTO " + USER_TABLE_NAME + " (first_name, last_name, email, phone, city, street, buildingNumber," +
                " apartment, username,  password, roles, permissions) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
            customUser.getFirstName(), customUser.getLastName(), customUser.getEmail(),
            customUser.getPhone(), customUser.getAddress().getCity(),
            customUser.getAddress().getStreet(), customUser.getAddress().getBuildingNumber(),
            customUser.getAddress().getApartment(),
            customUser.getUsername(), customUser.getPassword(),
            customUser.getRoles(), customUser.getPermissions());
    }


    @Override
    public void deleteUserById(Long userId) {
        String sql = "DELETE FROM " + USER_TABLE_NAME + " WHERE user_id=?";
        jdbcTemplate.update(sql, userId);
    }

    @Override
    public CustomUser getUserById(Long userId) {
        String sql = "SELECT * FROM " + USER_TABLE_NAME + " WHERE user_id =?";
        try {
            return jdbcTemplate.queryForObject(sql, userMapper, userId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public CustomUser getUserByEmail(String email) {
        String sql = "SELECT * FROM " + USER_TABLE_NAME + " WHERE email =?";
        try {
            return jdbcTemplate.queryForObject(sql, userMapper, email);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public CustomUser findUserByUsername(String username) {
        String sql = "SELECT * FROM " + USER_TABLE_NAME + " WHERE username=?";
        try {
            return jdbcTemplate.queryForObject(sql, new UserMapper(), username);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }


}

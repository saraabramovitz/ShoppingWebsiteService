package com.soppingWebsite.repository;

import com.soppingWebsite.model.User;
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
    public void createUser(User user) {
        String sql = "INSERT INTO " + USER_TABLE_NAME + " (first_name, last_name, email, phone, address, username, password) values (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(
            sql,
            user.getFirstName(),
            user.getLastName(),
            user.getEmail(),
            user.getPhone(),
            user.getAddress(),
            user.getUsername(),
            user.getPassword()
        );
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE " + USER_TABLE_NAME + " SET first_name=?, last_name=?, email=?, phone=?, address=?, username=?, password=? WHERE user_id=?";
        jdbcTemplate.update(
            sql,
            user.getFirstName(),
            user.getLastName(),
            user.getEmail(),
            user.getPhone(),
            user.getAddress(),
            user.getUsername(),
            user.getPassword(),
            user.getUserId()
        );
    }

    @Override
    public void deleteUserById(Long userId) {
        String sql = "DELETE FROM " + USER_TABLE_NAME + " WHERE user_id=?";
        jdbcTemplate.update(sql, userId);
    }

    @Override
    public User getUserById(Long userId) {
        String sql = "SELECT * FROM " + USER_TABLE_NAME + " WHERE user_id =?";
        try {
            return jdbcTemplate.queryForObject(sql, userMapper, userId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public User getUserByEmail(String email) {
        String sql = "SELECT * FROM " + USER_TABLE_NAME + " WHERE email =?";
        try {
            return jdbcTemplate.queryForObject(sql, userMapper, email);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public User getUserByUsername(String username) {
        String sql = "SELECT * FROM " + USER_TABLE_NAME + " WHERE username =?";
        try {
            return jdbcTemplate.queryForObject(sql, userMapper, username);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


}

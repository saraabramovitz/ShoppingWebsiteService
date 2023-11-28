package com.soppingWebsite.repository;

import com.soppingWebsite.model.Order;
import com.soppingWebsite.repository.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    OrderMapper orderMapper;

    public static final String ORDER_TABLE_NAME = "user_order";

    @Override
    public Long createOrder(Long userId, String shippingAddress) {
        String sql = "INSERT INTO " + ORDER_TABLE_NAME + " (user_id, shipping_address) values (?, ?)";
        jdbcTemplate.update(
            sql,
            userId,
            shippingAddress
        );
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Long.class);
    }

    @Override
    public void updateShippingAddress(Long orderId, String shippingAddress) {
        String sql = "UPDATE " + ORDER_TABLE_NAME + " SET shipping_address=? WHERE user_order_id=?";
        jdbcTemplate.update(
                sql,
                shippingAddress,
                orderId
        );
    }

    @Override
    public void closeOrder(Long orderId) {
        String sql = "UPDATE " + ORDER_TABLE_NAME + " SET status=? WHERE user_order_id=?";
        jdbcTemplate.update(
            sql,
            "CLOSE",
            orderId
        );
    }

    @Override
    public void deleteOrderById(Long orderId) {
        String sql = "DELETE FROM " + ORDER_TABLE_NAME + " WHERE user_order_id=?";
        jdbcTemplate.update(sql, orderId);
    }

    @Override
    public void deleteOrderByUserId(Long userId) {
        String sql = "DELETE FROM " + ORDER_TABLE_NAME + " WHERE user_id=?";
        jdbcTemplate.update(sql, userId);
    }

    @Override
    public Order getOrderById(Long orderId) {
        String sql = "SELECT * FROM " + ORDER_TABLE_NAME + " WHERE user_order_id=?";
        try {
            return jdbcTemplate.queryForObject(sql, orderMapper, orderId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Order> getOrdersByUserId(Long userId) {
        String sql = "SELECT * FROM " + ORDER_TABLE_NAME + " WHERE user_id=?";
        return jdbcTemplate.query(sql, orderMapper, userId);
    }

    @Override
    public Order getTempOrderByUserId(Long userId) {
        String sql = "SELECT * FROM " + ORDER_TABLE_NAME + " WHERE status=? and user_id=?";
        try {
            return jdbcTemplate.queryForObject(sql, orderMapper, "TEMP", userId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Order getTempOrderByOrderId(Long orderId) {
        String sql = "SELECT * FROM " + ORDER_TABLE_NAME + " WHERE status=? and user_order_id=?";
        try {
            return jdbcTemplate.queryForObject(sql, orderMapper, "TEMP", orderId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}

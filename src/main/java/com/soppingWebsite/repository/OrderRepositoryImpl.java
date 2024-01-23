package com.soppingWebsite.repository;

import com.soppingWebsite.model.Address;
import com.soppingWebsite.model.Order;
import com.soppingWebsite.model.OrderResponse;
import com.soppingWebsite.model.ShippingAddress;
import com.soppingWebsite.repository.mapper.OrderResponseMapper;
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
    OrderResponseMapper orderResponseMapper;

    public static final String ORDER_TABLE_NAME = "user_order";

    @Override
    public Long createOrder(Long userId, Address shippingAddress) {
        String sql = "INSERT INTO " + ORDER_TABLE_NAME + " (user_id, city, street, buildingNumber, apartment) values (?, ?, ?, ?, ?)";
        jdbcTemplate.update(
            sql,
            userId,
            shippingAddress.getCity(),
            shippingAddress.getStreet(),
            shippingAddress.getBuildingNumber(),
            shippingAddress.getApartment()
            );
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Long.class);
    }

    @Override
    public void updateShippingAddress(ShippingAddress shippingAddress) {
        String sql = "UPDATE " + ORDER_TABLE_NAME + " SET city=?, street=?, buildingNumber=?, apartment=? WHERE user_order_id=?";
        jdbcTemplate.update(
            sql,
            shippingAddress.getAddress().getCity(),
            shippingAddress.getAddress().getStreet(),
            shippingAddress.getAddress().getBuildingNumber(),
            shippingAddress.getAddress().getApartment(),
            shippingAddress.getOrderId()
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
    public OrderResponse getOrderById(Long orderId) {
        String sql = "SELECT * FROM " + ORDER_TABLE_NAME + " WHERE user_order_id=?";
        try {
            return jdbcTemplate.queryForObject(sql, orderResponseMapper, orderId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<OrderResponse> getOrdersByUserId(Long userId) {
        String sql = "SELECT * FROM " + ORDER_TABLE_NAME + " WHERE user_id=?" +
                " ORDER BY order_date DESC";
        return jdbcTemplate.query(sql, orderResponseMapper, userId);
    }

    @Override
    public OrderResponse getTempOrderByUserId(Long userId) {
        String sql = "SELECT * FROM " + ORDER_TABLE_NAME + " WHERE status=? and user_id=?";
        try {
            return jdbcTemplate.queryForObject(sql, orderResponseMapper, "TEMP", userId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public OrderResponse getTempOrderByOrderId(Long orderId) {
        String sql = "SELECT * FROM " + ORDER_TABLE_NAME + " WHERE status=? and user_order_id=?";
        try {
            return jdbcTemplate.queryForObject(sql, orderResponseMapper, "TEMP", orderId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}

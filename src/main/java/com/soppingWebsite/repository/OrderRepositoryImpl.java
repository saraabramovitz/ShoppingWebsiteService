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
    public void createOrder(Order order) {
        String sql = "INSERT INTO " + ORDER_TABLE_NAME + " (user_id, shipping_address, total_price) values (?, ?, ?)";
        jdbcTemplate.update(
            sql,
            order. getUserId(),
            order.getShippingAddress(),
            order.getTotalPrice()
        );
    }

    @Override
    public void updateOrder(Order order) {
        String sql = "UPDATE " + ORDER_TABLE_NAME + " SET shipping_address=?, total_price=?, status=? WHERE user_order_id=?";
        jdbcTemplate.update(
            sql,
            order.getShippingAddress(),
            order.getTotalPrice(),
            order.getOrderStatus(),
            order.getOrderId()
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
        return null;
    }
}

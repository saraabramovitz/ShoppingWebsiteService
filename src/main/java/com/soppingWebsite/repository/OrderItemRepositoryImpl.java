package com.soppingWebsite.repository;

import com.soppingWebsite.model.*;
import com.soppingWebsite.repository.mapper.OrderItemMapper;
import com.soppingWebsite.repository.mapper.OrderItemResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderItemRepositoryImpl implements OrderItemRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    OrderItemMapper orderItemMapper;
    @Autowired
    OrderItemResponseMapper orderItemResponseMapper;

    public static final String ORDER_ITEM_TABLE_NAME = "order_item";

    @Override
    public Long createOrderItem(OrderItemRequest orderItemRequest, Long orderId) {
        String sql = "INSERT INTO " + ORDER_ITEM_TABLE_NAME + " (user_order_id, item_id) values (?, ?);";
        jdbcTemplate.update(
            sql,
            orderId,
            orderItemRequest.getItemId()
        );
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Long.class);
    }

    @Override
    public void updateOrderItemQuantity (OrderItemQuantity orderItemQuantity) {
        String sql = "UPDATE " + ORDER_ITEM_TABLE_NAME + " SET quantity=? WHERE order_item_id=?;";
        jdbcTemplate.update(
            sql,
            orderItemQuantity.getQuantity(),
            orderItemQuantity.getOrderItemId()
        );
    }

    @Override
    public void deleteOrderItemById(Long orderItemId) {
        String sql = "DELETE FROM " + ORDER_ITEM_TABLE_NAME + " WHERE order_item_id=?;";
        jdbcTemplate.update(sql, orderItemId);
    }

    @Override
    public void deleteOrderItemByOrderId(Long orderId) {
        String sql = "DELETE FROM " + ORDER_ITEM_TABLE_NAME + " WHERE user_order_id=?;";
        jdbcTemplate.update(sql, orderId);
    }

    @Override
    public void deleteOrderItemByUserId(Long userId) {
        String sql = "DELETE FROM " + ORDER_ITEM_TABLE_NAME + " WHERE user_order_id IN (SELECT user_order_id FROM user_order WHERE user_id = ?);";
        jdbcTemplate.update(sql, userId);

    }

    @Override
    public OrderItem getOrderItemById(Long orderItemId) {
        String sql = "SELECT * FROM " + ORDER_ITEM_TABLE_NAME + " WHERE order_item_id=?;";
        try {
            return jdbcTemplate.queryForObject(sql, orderItemMapper, orderItemId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<OrderItemResponse> getOrderItemsByOrderId(Long orderId) {
        String sql = "SELECT " +
                "order_item.order_item_id, " +
                "order_item.item_id, " +
                "order_item.user_order_id, " +
                "item.item_name, " +
                "item.item_image, " +
                "item.item_overview, " +
                "item.item_details, " +
                "item.item_measurements, " +
                "item.price, " +
                "item.stock, " +
                "order_item.quantity " +
                "FROM " + ORDER_ITEM_TABLE_NAME + " " +
                "JOIN item ON order_item.item_id = item.item_id " +
                "WHERE order_item.user_order_id = ?;";
        return jdbcTemplate.query(sql, orderItemResponseMapper, orderId);
    }


    @Override
    public Item getItemIdByOrderItemId(Long orderItemId) {
        return null;
    }

    @Override
    public OrderItem getOrderItemByOrderIdAndItemId(Long orderId, Long itemId) {
        String sql = "SELECT * FROM " + ORDER_ITEM_TABLE_NAME + " WHERE user_order_id=? and item_id=?;";
        try {
            return jdbcTemplate.queryForObject(sql, orderItemMapper, orderId, itemId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }

    @Override
    public List<OrderItem> getOrderItemsByUserId(Long userId) {
        String sql = "SELECT order_item.* " + " FROM " + ORDER_ITEM_TABLE_NAME + " " +
        "JOIN user_order ON order_item.user_order_id = user_order.user_order_id " +
        "WHERE user_order.user_id = ?;";
        return jdbcTemplate.query(sql, orderItemMapper, userId);
    }

    @Override
    public List<OrderItemResponse> getOrderItemsByTempOrder(Long userId) {
        String sql = "SELECT " +
            "order_item.order_item_id, " +
            "order_item.item_id, " +
            "order_item.user_order_id, " +
            "item.item_name, " +
            "item.item_image, " +
            "item.item_overview, " +
            "item.item_details, " +
            "item.item_measurements, " +
            "item.price, " +
            "item.stock, "+
            "item.price, " +
            "order_item.quantity " +
            "FROM  " + ORDER_ITEM_TABLE_NAME + " " +
            "JOIN user_order ON order_item.user_order_id = user_order.user_order_id " +
            "JOIN item ON order_item.item_id = item.item_id " +
            "WHERE user_order.status = ? AND user_order.user_id = ?;";
        return jdbcTemplate.query(sql, orderItemResponseMapper, "TEMP", userId);
    }


    }

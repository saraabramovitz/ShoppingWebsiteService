package com.soppingWebsite.repository;

import com.soppingWebsite.model.OrderProduct;
import com.soppingWebsite.repository.mapper.OrderProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderProductRepositoryImpl implements OrderProductRepository{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    OrderProductMapper orderProductMapper;

    public static final String ORDER_PRODUCT_TABLE_NAME = "order_product";

    @Override
    public void createOrderProduct(OrderProduct orderProduct) {
        String sql = "INSERT INTO " + ORDER_PRODUCT_TABLE_NAME + " (user_order_id, product_id, quantity) values (?, ?, ?)";
        jdbcTemplate.update(
            sql,
            orderProduct.getOrderProductId(),
            orderProduct.getProductId(),
            orderProduct.getQuantity()
        );
    }

    @Override
    public void updateOrderProduct(OrderProduct orderProduct) {
        String sql = "UPDATE " + ORDER_PRODUCT_TABLE_NAME + " SET quantity WHERE order_product_id=?";
        jdbcTemplate.update(
            sql,
            orderProduct.getQuantity(),
            orderProduct.getOrderProductId()
        );
    }

    @Override
    public void deleteOrderProductById(Long orderProductId) {
        String sql = "DELETE FROM " + ORDER_PRODUCT_TABLE_NAME + " WHERE order_product_id=?";
        jdbcTemplate.update(sql, orderProductId);
    }

    @Override
    public void deleteOrderProductByUserId(Long userId) {
        String sql = "DELETE * FROM " + ORDER_PRODUCT_TABLE_NAME + " WHERE user_order_id=?";
        jdbcTemplate.update(sql, userId);
    }

    @Override
    public OrderProduct getOrderProductById(Long orderProductId) {
        String sql = "SELECT * FROM " + ORDER_PRODUCT_TABLE_NAME + " WHERE order_product_id=?";
        try {
            return jdbcTemplate.queryForObject(sql, orderProductMapper, orderProductId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<OrderProduct> getOrderProductsByUserId(Long userId) {
        String sql = "SELECT * FROM " + ORDER_PRODUCT_TABLE_NAME + " WHERE user_id = ?";
        return jdbcTemplate.query(sql, orderProductMapper, userId);
    }

    @Override
    public List<OrderProduct> getOrderProductsByOrderId(Long orderId) {
        String sql = "SELECT * FROM " + ORDER_PRODUCT_TABLE_NAME + " WHERE user_order_id = ?";
        return jdbcTemplate.query(sql, orderProductMapper, orderId);
    }
}

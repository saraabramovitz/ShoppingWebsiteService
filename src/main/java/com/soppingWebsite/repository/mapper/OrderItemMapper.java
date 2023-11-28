package com.soppingWebsite.repository.mapper;

import com.soppingWebsite.model.OrderProduct;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class OrderProductMapper implements RowMapper<OrderProduct> {
    @Override
    public OrderProduct mapRow(ResultSet rs, int rowNum) throws SQLException {

        OrderProduct orderProduct = new OrderProduct(
            rs.getLong("order_product_id"),
            rs.getLong("user_id"),
            rs.getLong("user_order_id"),
            rs.getLong("product_id"),
            rs.getDouble("price"),
            rs.getInt("quantity")
        );

        return orderProduct;
    }
}

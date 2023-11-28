package com.soppingWebsite.repository.mapper;

import com.soppingWebsite.model.OrderItem;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class OrderItemMapper implements RowMapper<OrderItem> {
    @Override
    public OrderItem mapRow(ResultSet rs, int rowNum) throws SQLException {

        OrderItem orderItem = new OrderItem(
            rs.getLong("order_item_id"),
            rs.getLong("item_id"),
            rs.getLong("user_order_id"),
            rs.getInt("quantity")
        );

        return orderItem;
    }
}

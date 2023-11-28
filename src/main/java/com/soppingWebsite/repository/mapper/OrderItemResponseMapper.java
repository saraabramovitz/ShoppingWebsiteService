package com.soppingWebsite.repository.mapper;

import com.soppingWebsite.model.OrderItem;
import com.soppingWebsite.model.OrderItemResponse;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class OrderItemResponseMapper implements RowMapper<OrderItemResponse> {
    @Override
    public OrderItemResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

        OrderItemResponse orderItemResponse = new OrderItemResponse(
                rs.getLong("order_item_id"),
                rs.getLong("user_order_id"),
                rs.getLong("item_id"),
                rs.getString("item_name"),
                rs.getString("item_image"),
                rs.getDouble("price"),
                rs.getInt("quantity")
        );

        return orderItemResponse;

    }
}

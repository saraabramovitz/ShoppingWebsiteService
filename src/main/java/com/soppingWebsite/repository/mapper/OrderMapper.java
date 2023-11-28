package com.soppingWebsite.repository.mapper;

import com.soppingWebsite.model.Order;
import com.soppingWebsite.model.modelEnum.OrderStatus;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class OrderMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {

        Order order = new Order(
            rs.getLong("user_order_id"),
            rs.getLong("user_id"),
            rs.getString("shipping_address"),
            rs.getTimestamp("order_date").toLocalDateTime().toLocalDate(),
            OrderStatus.valueOf(rs.getString("status"))
        );

        return order;
    }
}

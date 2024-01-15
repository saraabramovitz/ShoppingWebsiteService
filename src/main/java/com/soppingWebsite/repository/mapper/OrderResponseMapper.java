package com.soppingWebsite.repository.mapper;

import com.soppingWebsite.model.OrderResponse;
import com.soppingWebsite.model.modelEnum.OrderStatus;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class OrderResponseMapper implements RowMapper<OrderResponse> {
    @Override
    public OrderResponse mapRow(ResultSet rs, int rowNum) throws SQLException {


        OrderResponse orderResponse = new OrderResponse(
            rs.getLong("user_order_id"),
            rs.getLong("user_id"),
            rs.getString("city"),
            rs.getString("street"),
            rs.getInt("buildingNumber"),
            rs.getInt("apartment"),
            rs.getTimestamp("order_date").toLocalDateTime().toLocalDate(),
            OrderStatus.valueOf(rs.getString("status"))
        );

        return orderResponse;
    }
}

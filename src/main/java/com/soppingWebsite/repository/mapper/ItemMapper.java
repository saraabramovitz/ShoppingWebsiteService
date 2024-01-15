package com.soppingWebsite.repository.mapper;

import com.soppingWebsite.model.Item;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ItemMapper implements RowMapper<Item> {
    @Override
    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {

        Item item = new Item(
            rs.getLong("item_id"),
            rs.getString("item_name"),
            rs.getString("item_image"),
            rs.getString("item_overview"),
            rs.getString("item_details"),
            rs.getString("item_measurements"),
            rs.getDouble("price"),
            rs.getLong("stock")
        );

        return item;
    }
}

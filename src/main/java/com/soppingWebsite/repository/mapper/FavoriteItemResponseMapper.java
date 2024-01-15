package com.soppingWebsite.repository.mapper;

import com.soppingWebsite.model.FavoriteItem;
import com.soppingWebsite.model.FavoriteItemResponse;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class FavoriteItemResponseMapper implements RowMapper<FavoriteItemResponse> {
    @Override
    public FavoriteItemResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

        FavoriteItemResponse favoriteItemResponse = new FavoriteItemResponse(
            rs.getLong("favorite_item_id"),
            rs.getLong("user_id"),
            rs.getLong("item_id"),
            rs.getString("item_name"),
            rs.getString("item_image"),
            rs.getString("item_overview"),
            rs.getString("item_details"),
            rs.getString("item_measurements"),
            rs.getDouble("price"),
            rs.getLong("stock")
            );
        return favoriteItemResponse;
    }
}

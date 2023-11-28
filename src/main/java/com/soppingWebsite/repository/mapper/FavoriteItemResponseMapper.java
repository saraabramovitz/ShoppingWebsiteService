package com.soppingWebsite.repository.mapper;

import com.soppingWebsite.model.FavoriteItem;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class FavoriteItemMapper implements RowMapper<FavoriteItem> {
    @Override
    public FavoriteItem mapRow(ResultSet rs, int rowNum) throws SQLException {

        FavoriteItem favoriteItem = new FavoriteItem(
            rs.getLong("favorite_item_id"),
            rs.getLong("item_id"),
                rs.getLong("user_id")
                );

        return favoriteItem;
    }
}

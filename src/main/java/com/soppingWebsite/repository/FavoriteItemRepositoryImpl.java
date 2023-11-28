package com.soppingWebsite.repository;

import com.soppingWebsite.model.FavoriteItem;
import com.soppingWebsite.model.FavoriteItemResponse;
import com.soppingWebsite.repository.mapper.FavoriteItemResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FavoriteItemRepositoryImpl implements FavoriteItemRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    FavoriteItemResponseMapper favoriteItemResponseMapper;

    public static final String FAVORITE_ITEM_TABLE_NAME = "favorite_item";


    @Override
    public void createFavoriteItem(FavoriteItem favoriteItem) {
        String sql = "INSERT INTO " + FAVORITE_ITEM_TABLE_NAME + " (user_id, item_id) values (?, ?)";
        jdbcTemplate.update(
            sql,
            favoriteItem.getUserId(),
            favoriteItem.getItemId()
        );
    }

    @Override
    public void deleteFavoriteItemById(Long favoriteItemId) {
        String sql = "DELETE FROM " + FAVORITE_ITEM_TABLE_NAME + " WHERE favorite_item_id=?";
        jdbcTemplate.update(sql, favoriteItemId);
    }

    @Override
    public void deleteFavoriteItemByUserId(Long userId) {
        String sql = "DELETE FROM " + FAVORITE_ITEM_TABLE_NAME + " WHERE user_id=?";
        jdbcTemplate.update(sql, userId);
    }

    @Override
    public FavoriteItemResponse getFavoriteItemById(Long favoriteItemId) {
        String sql = "SELECT favorite_item.favorite_item_id, " +
                "favorite_item.user_id, " +
                "favorite_item.item_id, " +
                "item.item_name, " +
                "item.item_image, " +
                "item.price, " +
                "item.stock " +
                "FROM favorite_item " +
                "JOIN item ON favorite_item.item_id = item.item_id " +
                "WHERE favorite_item.favorite_item_id = ?";        try {
            return jdbcTemplate.queryForObject(sql, favoriteItemResponseMapper, favoriteItemId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<FavoriteItemResponse> getAllFavoriteItemsByUserId(Long userId) {
        String sql = "SELECT favorite_item.favorite_item_id, " +
                "favorite_item.user_id, " +
                "favorite_item.item_id, " +
                "item.item_name, " +
                "item.item_image, " +
                "item.price, " +
                "item.stock " +
                "FROM favorite_item " +
                "JOIN item ON favorite_item.item_id = item.item_id " +
                "WHERE favorite_item.user_id = ?";
        return jdbcTemplate.query(sql, favoriteItemResponseMapper, userId);
    }
}

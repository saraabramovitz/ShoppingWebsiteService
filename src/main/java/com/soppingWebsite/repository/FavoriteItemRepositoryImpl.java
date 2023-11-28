package com.soppingWebsite.repository;

import com.soppingWebsite.model.FavoriteProduct;
import com.soppingWebsite.repository.mapper.FavoriteProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FavoriteProductRepositoryImpl implements FavoriteProductRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    FavoriteProductMapper favoriteProductMapper;

    public static final String FAVORITE_PRODUCT_TABLE_NAME = "favorite";


    @Override
    public void createFavoriteProduct(FavoriteProduct favoriteProduct) {
        String sql = "INSERT INTO " + FAVORITE_PRODUCT_TABLE_NAME + " (user_id, product_id) values (?, ?)";
        jdbcTemplate.update(
            sql,
            favoriteProduct.getUserId(),
            favoriteProduct.getProductId()
        );
    }

    @Override
    public void deleteFavoriteProductById(Long favoriteProductId) {
        String sql = "DELETE FROM " + FAVORITE_PRODUCT_TABLE_NAME + " WHERE favorite_id=?";
        jdbcTemplate.update(sql, favoriteProductId);
    }

    @Override
    public void deleteFavoriteProductByUserId(Long userId) {
        String sql = "DELETE * FROM " + FAVORITE_PRODUCT_TABLE_NAME + " WHERE user_id=?";
        jdbcTemplate.update(sql, userId);
    }

    @Override
    public FavoriteProduct getFavoriteProductById(Long favoriteProductId) {
        String sql = "SELECT * FROM " + FAVORITE_PRODUCT_TABLE_NAME + " WHERE favorite_id=?";
        try {
            return jdbcTemplate.queryForObject(sql, favoriteProductMapper, favoriteProductId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<FavoriteProduct> getAllFavoriteProductsByUserId(Long userId) {
        String sql = "SELECT * FROM " + FAVORITE_PRODUCT_TABLE_NAME + " WHERE user_id = ?";
        return jdbcTemplate.query(sql, favoriteProductMapper, userId);
    }
}

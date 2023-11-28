package com.soppingWebsite.repository;

import com.soppingWebsite.model.Item;
import com.soppingWebsite.repository.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItamRepositoryImpl implements ItamRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    ItemMapper productMapper;

    public static final String PRODUCT_TABLE_NAME = "product";


    @Override
    public void createProduct(Item item) {
        String sql = "INSERT INTO " + PRODUCT_TABLE_NAME + " (product_name, product_image, price, stock) values (?, ?, ?, ?)";
        jdbcTemplate.update(
            sql,
            item.getProductName(),
            item.getProductImage(),
            item.getPrice(),
            item.getStock()
        );
    }

    @Override
    public void updateProduct(Item item) {
        String sql = "UPDATE " + PRODUCT_TABLE_NAME + " SET product_name=?, product_image=?, price=?, stock=?, WHERE product_id=?";
        jdbcTemplate.update(
                sql,
                item.getProductName(),
                item.getProductImage(),
                item.getPrice(),
                item.getStock(),
                item.getProductId()
        );
    }

    @Override
    public void deleteProductById(Long productId) {
        String sql = "DELETE FROM " + PRODUCT_TABLE_NAME + " WHERE product_id=?";
        jdbcTemplate.update(sql, productId);

    }

    @Override
    public Item getProductById(Long productId) {
        String sql = "SELECT * FROM " + PRODUCT_TABLE_NAME + " WHERE product_id =?";
        try {
            return jdbcTemplate.queryForObject(sql, productMapper, productId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Item> getAllProducts() {
        String sql = "SELECT * FROM " + PRODUCT_TABLE_NAME;
        return jdbcTemplate.query(sql, productMapper);
    }

    @Override
    public List<Item> getProductsContainingSearchText(String searchText) {
        String sql = "SELECT * FROM " + PRODUCT_TABLE_NAME + " WHERE product_name LIKE ?";
        return jdbcTemplate.query(sql, productMapper,  "%" + searchText + "%");
    }


}

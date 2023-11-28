package com.soppingWebsite.repository.mapper;

import com.soppingWebsite.model.Product;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProductMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

        Product product = new Product(
            rs.getLong("product_id"),
            rs.getString("product_name"),
            rs.getString("product_image"),
            rs.getDouble("price"),
            rs.getLong("stock")
        );

        return product;
    }
}

package com.soppingWebsite.repository;

import com.soppingWebsite.model.Item;
import com.soppingWebsite.repository.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    ItemMapper itemMapper;

    public static final String ITEM_TABLE_NAME = "item";


    @Override
    public void createItem(Item item) {
        String sql = "INSERT INTO " + ITEM_TABLE_NAME + " (item_name, item_image, price, stock) values (?, ?, ?, ?)";
        jdbcTemplate.update(
            sql,
            item.getItemName(),
            item.getItemImage(),
            item.getPrice(),
            item.getStock()
        );
    }

    @Override
    public void updateItem(Item item) {
        String sql = "UPDATE " + ITEM_TABLE_NAME + " SET item_name=?, item_image=?, price=?, stock=? WHERE item_id=?";
        jdbcTemplate.update(
            sql,
            item.getItemName(),
            item.getItemImage(),
            item.getPrice(),
            item.getStock(),
            item.getItemId()
        );
    }

    public void updateStock(Long itemId, Long stock) {
        String sql = "UPDATE " + ITEM_TABLE_NAME + " SET stock=? WHERE item_id=?";
        jdbcTemplate.update(sql, stock, itemId);
    }

    @Override
    public void deleteItemById(Long itemId) {
        String sql = "DELETE FROM " + ITEM_TABLE_NAME + " WHERE item_id=?";
        jdbcTemplate.update(sql, itemId);

    }

    @Override
    public Item getItemById(Long itemId) {
        String sql = "SELECT * FROM " + ITEM_TABLE_NAME + " WHERE item_id =?";
        try {
            return jdbcTemplate.queryForObject(sql, itemMapper, itemId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Item> getAllItems() {
        String sql = "SELECT * FROM " + ITEM_TABLE_NAME;
        return jdbcTemplate.query(sql, itemMapper);
    }

    @Override
    public List<Item> getItemsContainingSearchText(String searchText) {
        String sql = "SELECT * FROM " + ITEM_TABLE_NAME + " WHERE LOWER(item_name) LIKE LOWER(?)";
        String lowerSearchText = "%" + searchText.toLowerCase() + "%";
        System.out.println("Search Text: " + lowerSearchText);
        List<Item> items = jdbcTemplate.query(sql, itemMapper, lowerSearchText);
        return items;
    }


}

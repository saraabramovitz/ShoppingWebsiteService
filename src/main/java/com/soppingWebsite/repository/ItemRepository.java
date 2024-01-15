package com.soppingWebsite.repository;

import com.soppingWebsite.model.Item;

import java.util.List;

public interface ItemRepository {
    void createItem (Item item);
    void updateItem (Item item);
    void updateStock (Long itemId, Long stock);
    void deleteItemById (Long productId);
    Item getItemById (Long productId);
    List<Item> getAllItems ();
    List<Item> getItemsContainingSearchText(String searchText);


}

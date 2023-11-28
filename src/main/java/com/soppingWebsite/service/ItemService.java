package com.soppingWebsite.service;

import com.soppingWebsite.model.Item;

import java.util.List;

public interface ItemService {
    void createItem (Item item);
    void updateItem (Item item);
    void deleteItemById (Long productId);
    Item getItemById (Long productId);
    List<Item> getAllItems ();
    List<Item> getItemsContainingSearchText(String searchText);

}

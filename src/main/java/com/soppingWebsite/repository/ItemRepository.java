package com.soppingWebsite.repository;

import com.soppingWebsite.model.Item;

import java.util.List;

public interface ItamRepository {
    void createProduct (Item item);
    void updateProduct (Item item);
    void deleteProductById (Long productId);
    Item getProductById (Long productId);
    List<Item> getAllProducts ();
    List<Item> getProductsContainingSearchText(String searchText);


}

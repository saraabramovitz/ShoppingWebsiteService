package com.soppingWebsite.service;

import com.soppingWebsite.model.Product;

import java.util.List;

public interface ProductService {
    void createProduct (Product product);
    void updateProduct (Product product);
    void deleteProductById (Long productId);
    Product getProductById (Long productId);
    List<Product> getAllProducts ();
    List<Product> getProductsContainingSearchText(String searchText);

}

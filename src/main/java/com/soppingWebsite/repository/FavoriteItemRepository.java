package com.soppingWebsite.repository;

import com.soppingWebsite.model.FavoriteProduct;

import java.util.List;

public interface FavoriteProductRepository {
    void createFavoriteProduct(FavoriteProduct favoriteProduct);
    void deleteFavoriteProductById(Long favoriteProductId);
    void deleteFavoriteProductByUserId(Long userId);
    FavoriteProduct getFavoriteProductById(Long favoriteProductId);
    List<FavoriteProduct> getAllFavoriteProductsByUserId (Long userId);
}

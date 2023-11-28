package com.soppingWebsite.service;

import com.soppingWebsite.model.FavoriteProduct;
import com.soppingWebsite.model.User;

import java.util.List;

public interface FavoriteProductService {
    void createFavoriteProduct(FavoriteProduct favoriteProduct);
    void deleteFavoriteProductById(Long favoriteProductId);
    void deleteFavoriteProductByUserId(Long userId);
    FavoriteProduct getFavoriteProductById(Long favoriteProductId);
    List<FavoriteProduct> getAllFavoriteProductsByUserId (Long userId);

}

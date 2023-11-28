package com.soppingWebsite.service;

import com.soppingWebsite.model.FavoriteProduct;
import com.soppingWebsite.repository.FavoriteProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class FavoriteProductServiceImpl implements FavoriteProductService{

    @Autowired
    FavoriteProductRepository favoriteProductRepository;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;

    @Override
    public void createFavoriteProduct(FavoriteProduct favoriteProduct) {
        if(favoriteProduct.getProductId() != null){
            throw new IllegalArgumentException("Invalid id.");
        }
        if(userService.getUserById(favoriteProduct.getUserId()) == null){
            throw new IllegalArgumentException("User does not exist.");
        }
        if(productService.getProductById(favoriteProduct.getFavoriteProductId()) == null){
            throw new IllegalArgumentException("Product does not exist.");
        }
        favoriteProductRepository.createFavoriteProduct(favoriteProduct);
    }

    @Override
    public void deleteFavoriteProductById(Long favoriteProductId) {
        if(favoriteProductRepository.getFavoriteProductById(favoriteProductId) == null){
            throw new IllegalArgumentException("Favorite product does not exist.");
        }

        favoriteProductRepository.deleteFavoriteProductById(favoriteProductId);
    }

    @Override
    public void deleteFavoriteProductByUserId(Long userId) {
        favoriteProductRepository.deleteFavoriteProductByUserId(userId);
    }

    @Override
    public FavoriteProduct getFavoriteProductById(Long favoriteProductId) {
        if(favoriteProductRepository.getFavoriteProductById(favoriteProductId) == null){
            throw new IllegalArgumentException("Favorite product does not exist.");
        }

        return favoriteProductRepository.getFavoriteProductById(favoriteProductId);
    }

    @Override
    public List<FavoriteProduct> getAllFavoriteProductsByUserId(Long userId) {
        return favoriteProductRepository.getAllFavoriteProductsByUserId(userId);
    }
}

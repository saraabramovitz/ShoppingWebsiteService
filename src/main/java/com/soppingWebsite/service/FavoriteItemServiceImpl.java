package com.soppingWebsite.service;

import com.soppingWebsite.model.FavoriteItem;
import com.soppingWebsite.model.FavoriteItemResponse;
import com.soppingWebsite.repository.FavoriteItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class FavoriteItemServiceImpl implements FavoriteItemService {

    @Autowired
    FavoriteItemRepository favoriteItemRepository;
    @Autowired
    ItemService itemService;
    @Autowired
    UserService userService;

    @Override
    public void createFavoriteItem(FavoriteItem favoriteItem) {
        if(favoriteItem.getFavoriteItemId() != null){
            throw new IllegalArgumentException("Invalid id.");
        }
        System.out.println(userService.getUserById(favoriteItem.getUserId()));
        if(userService.getUserById(favoriteItem.getUserId()) == null){
            throw new IllegalArgumentException("CustomUser does not exist.");
        }
        if(itemService.getItemById(favoriteItem.getItemId()) == null){
            throw new IllegalArgumentException("Item does not exist.");
        }
        favoriteItemRepository.createFavoriteItem(favoriteItem);
    }

    @Override
    public void deleteFavoriteItemById(Long favoriteItemId) {
        System.out.println(favoriteItemId);
        if(favoriteItemRepository.getFavoriteItemById(favoriteItemId) == null){
            throw new IllegalArgumentException("Favorite item does not exist.");
        }

        favoriteItemRepository.deleteFavoriteItemById(favoriteItemId);
    }

    @Override
    public void deleteFavoriteItemByUserId(Long userId) {
        favoriteItemRepository.deleteFavoriteItemByUserId(userId);
    }

    @Override
    public FavoriteItemResponse getFavoriteItemById(Long favoriteItemId) {
        if(favoriteItemRepository.getFavoriteItemById(favoriteItemId) == null){
            throw new IllegalArgumentException("Favorite item does not exist.");
        }

        return favoriteItemRepository.getFavoriteItemById(favoriteItemId);
    }

    @Override
    public List<FavoriteItemResponse> getAllFavoriteItemsByUserId(Long userId) {
        return favoriteItemRepository.getAllFavoriteItemsByUserId(userId);
    }
}

package com.soppingWebsite.repository;

import com.soppingWebsite.model.FavoriteItem;
import com.soppingWebsite.model.FavoriteItemResponse;

import java.util.List;

public interface FavoriteItemRepository {
    Long createFavoriteItem(FavoriteItem favoriteItem);
    void deleteFavoriteItem(Long favoriteItemId);
    void deleteFavoriteItemByUserId(Long userId);
    FavoriteItemResponse getFavoriteItemById(Long favoriteItemId);
    List<FavoriteItemResponse> getAllFavoriteItemsByUserId (Long userId);
}

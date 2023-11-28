package com.soppingWebsite.model;

public class FavoriteItem {

    private Long favoriteItemId;
    private Long itemId;
    private Long userId;

    public FavoriteItem() {}

    public FavoriteItem(Long favoriteItemId, Long itemId, Long userId) {
        this.favoriteItemId = favoriteItemId;
        this.itemId = itemId;
        this.userId = userId;
    }

    public Long getFavoriteItemId() {
        return favoriteItemId;
    }

    public Long getItemId() {
        return itemId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setFavoriteItemId(Long favoriteItemId) {
        this.favoriteItemId = favoriteItemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

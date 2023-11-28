package com.soppingWebsite.model;

public class FavoriteItemResponse {
    private Long favoriteItemId;
    private Long userId;
    private Long itemId;
    private String itemName;
    private String itemImage;
    private Double price;
    private Long stock;

    public FavoriteItemResponse(){}

    public FavoriteItemResponse(Long favoriteItemId, Long userId, Long itemId, String itemName, String itemImage, Double price, Long stock) {
        this.favoriteItemId = favoriteItemId;
        this.userId = userId;
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemImage = itemImage;
        this.price = price;
        this.stock = stock;
    }

    public Long getFavoriteItemId() {
        return favoriteItemId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemImage() {
        return itemImage;
    }

    public Double getPrice() {
        return price;
    }

    public Long getStock() {
        return stock;
    }

    public void setFavoriteItemId(Long favoriteItemId) {
        this.favoriteItemId = favoriteItemId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }
}

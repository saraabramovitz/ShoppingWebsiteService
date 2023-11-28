package com.soppingWebsite.model;

public class FavoriteProduct {

    private Long favoriteProductId;
    private Long productId;
    private Long userId;

    public FavoriteProduct() {}

    public FavoriteProduct(Long favoriteProductId, Long productId, Long userId) {
        this.favoriteProductId = favoriteProductId;
        this.productId = productId;
        this.userId = userId;
    }

    public Long getFavoriteProductId() {
        return favoriteProductId;
    }

    public Long getProductId() {
        return productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setFavoriteProductId(Long favoriteProductId) {
        this.favoriteProductId = favoriteProductId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

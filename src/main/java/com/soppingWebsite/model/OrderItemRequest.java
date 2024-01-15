package com.soppingWebsite.model;

public class OrderItemRequest {
    private Long itemId;
    private Long userId;

    public OrderItemRequest() {
    }

    public OrderItemRequest(Long itemId, Long userId) {
        this.itemId = itemId;
        this.userId = userId;
    }

    public Long getItemId() {
        return itemId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}


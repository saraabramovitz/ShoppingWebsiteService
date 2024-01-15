package com.soppingWebsite.model;

public class OrderItemQuantity {

    Long orderItemId;
    Integer quantity;

    public OrderItemQuantity(Long orderItemId, Integer quantity) {
        this.orderItemId = orderItemId;
        this.quantity = quantity;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

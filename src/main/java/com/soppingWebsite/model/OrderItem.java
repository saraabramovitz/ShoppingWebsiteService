package com.soppingWebsite.model;

public class OrderItem {
    private Long orderItemId;
    private Long itemId;
    private Long orderId;
    private Integer quantity;

    public OrderItem() {}

    public OrderItem(Long orderItemId, Long itemId, Long orderId, Integer quantity) {
        this.orderItemId = orderItemId;
        this.itemId = itemId;
        this.orderId = orderId;
        this.quantity = quantity;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }


    public Long getItemId() {
        return itemId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }


    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}


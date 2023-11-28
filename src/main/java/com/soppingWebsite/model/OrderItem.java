package com.soppingWebsite.model;

public class OrderProduct {
    private Long orderProductId;
    private Long userId;
    private Long orderId;
    private Long productId;
    private Double productPrice;
    private Integer quantity;

    public OrderProduct() {}

    public OrderProduct(Long orderProductId, Long userId, Long orderId, Long productId, Double productPrice, Integer quantity) {
        this.orderProductId = orderProductId;
        this.userId = userId;
        this.orderId = orderId;
        this.productId = productId;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }

    public Long getOrderProductId() {
        return orderProductId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setOrderProductId(Long orderProductId) {
        this.orderProductId = orderProductId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}


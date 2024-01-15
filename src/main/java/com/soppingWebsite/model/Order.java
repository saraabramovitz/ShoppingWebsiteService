package com.soppingWebsite.model;

import com.soppingWebsite.model.modelEnum.OrderStatus;

import java.time.LocalDate;

public class Order {
    private Long orderId;
    private Long userId;
    private Address shippingAddress;
    private LocalDate orderDate;
    private OrderStatus orderStatus;

    public Order() {}

    public Order(Long orderId, Long userId, Address shippingAddress, LocalDate orderDate, OrderStatus orderStatus) {
        this.orderId = orderId;
        this.userId = userId;
        this.shippingAddress = shippingAddress;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}


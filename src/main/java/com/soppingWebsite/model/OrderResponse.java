package com.soppingWebsite.model;

import com.soppingWebsite.model.modelEnum.OrderStatus;

import java.time.LocalDate;

public class OrderResponse {
    private Long orderId;
    private Long userId;
    private String city;
    private String street;
    private Integer buildingNumber;
    private Integer apartment;
    private LocalDate orderDate;
    private OrderStatus orderStatus;

    OrderResponse(){}

    public OrderResponse(Long orderId, Long userId, String city, String street, Integer buildingNumber, Integer apartment, LocalDate orderDate, OrderStatus orderStatus) {
        this.orderId = orderId;
        this.userId = userId;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.apartment = apartment;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public Integer getBuildingNumber() {
        return buildingNumber;
    }

    public Integer getApartment() {
        return apartment;
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

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setBuildingNumber(Integer buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public void setApartment(Integer apartment) {
        this.apartment = apartment;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}

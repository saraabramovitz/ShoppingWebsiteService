package com.soppingWebsite.model;

public class ShippingAddress {
    Long orderId;
    Address address;

    public ShippingAddress() {
    }

    public ShippingAddress(Long orderId, Address address) {
        this.orderId = orderId;
        this.address = address;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Address getAddress() {
        return address;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

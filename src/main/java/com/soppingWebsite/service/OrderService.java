package com.soppingWebsite.service;

import com.soppingWebsite.model.Order;

import java.util.List;

public interface OrderService {
    Long createOrder (Long userId, String shippingAddress);
    void updateShippingAddress(Long orderId, String shippingAddress);
    void closeOrder (Long orderId);
    void deleteOrderById (Long orderId);
    void deleteOrderByUserId (Long userId);
    Order getOrderById (Long orderId);
    List<Order> getOrdersByUserId (Long userId);
    Order getTempOrderByUserId(Long userId);

}

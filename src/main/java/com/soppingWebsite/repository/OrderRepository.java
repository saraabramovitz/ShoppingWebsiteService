package com.soppingWebsite.repository;

import com.soppingWebsite.model.*;

import java.util.List;

public interface OrderRepository {
    Long createOrder(Long userId, Address shippingAddress);
    void updateShippingAddress(ShippingAddress shippingAddress);
    void closeOrder(Long orderId);
    void deleteOrderById (Long orderId);
    void deleteOrderByUserId (Long userId);
    OrderResponse getOrderById (Long orderId);
    List<OrderResponse> getOrdersByUserId (Long userId);
    OrderResponse getTempOrderByUserId(Long userId);
    OrderResponse getTempOrderByOrderId(Long orderId);

}

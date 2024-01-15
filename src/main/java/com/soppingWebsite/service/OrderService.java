package com.soppingWebsite.service;

import com.soppingWebsite.model.Address;
import com.soppingWebsite.model.Order;
import com.soppingWebsite.model.OrderResponse;
import com.soppingWebsite.model.ShippingAddress;

import java.util.List;

public interface OrderService {
    Long createOrder (Long userId, Address shippingAddress);
    void updateShippingAddress(ShippingAddress shippingAddress);
    void closeOrder (Long orderId);
    void deleteOrderById (Long orderId);
    void deleteOrderByUserId (Long userId);
    OrderResponse getOrderById (Long orderId);
    List<OrderResponse> getOrdersByUserId (Long userId);
    OrderResponse getTempOrderByUserId(Long userId);

}

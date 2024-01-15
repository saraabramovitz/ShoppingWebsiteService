package com.soppingWebsite.service;

import com.soppingWebsite.model.*;

import java.util.List;

public interface OrderItemService {
    OrderItem createOrderItem(OrderItemRequest orderItemRequest);
    void updateOrderItemQuantity (OrderItemQuantity orderItemQuantity);
    void deleteOrderItemById (Long orderProductId);
    void deleteOrderItemByOrderId (Long orderId);
    void deleteOrderItemByUserId(Long userId);
    OrderItem getOrderItemById (Long orderProductId);
    List<OrderItemResponse> getOrderItemsByOrderId(Long orderId);
    List<OrderItem> getOrderItemsByUserId(Long userId);
    List<OrderItemResponse> getOrderItemsByTempOrder(Long userId);


}

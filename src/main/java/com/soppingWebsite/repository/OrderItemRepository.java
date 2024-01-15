package com.soppingWebsite.repository;

import com.soppingWebsite.model.*;

import java.util.List;

public interface OrderItemRepository {
    Long createOrderItem (OrderItemRequest orderItemRequest, Long orderId);
    void updateOrderItemQuantity (OrderItemQuantity orderItemQuantity);
    void deleteOrderItemById (Long orderItemId);
    void deleteOrderItemByOrderId (Long order);
    void deleteOrderItemByUserId(Long userId);
    OrderItem getOrderItemById (Long orderItemId);
    List<OrderItemResponse> getOrderItemsByOrderId (Long orderId);
    Item getItemIdByOrderItemId (Long orderItemId);
    OrderItem getOrderItemByOrderIdAndItemId(Long orderId, Long itemId);
    List<OrderItem> getOrderItemsByUserId(Long userId);
    List<OrderItemResponse> getOrderItemsByTempOrder(Long userId);

}

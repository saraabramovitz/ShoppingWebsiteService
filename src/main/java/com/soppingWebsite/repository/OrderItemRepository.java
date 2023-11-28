package com.soppingWebsite.repository;

import com.soppingWebsite.model.OrderProduct;

import java.util.List;

public interface OrderProductRepository {
    void createOrderProduct (OrderProduct orderProduct);
    void updateOrderProduct (OrderProduct orderProduct);
    void deleteOrderProductById (Long orderProductId);
    void deleteOrderProductByUserId (Long userId);
    OrderProduct getOrderProductById (Long orderProductId);
    List<OrderProduct> getOrderProductsByUserId (Long userId);
    List<OrderProduct> getOrderProductsByOrderId (Long orderId);

}

package com.soppingWebsite.model;

import java.util.List;

public class OrderWithItemsResponse {
    OrderResponse order;
    List<OrderItemResponse> orderItems;

    public OrderWithItemsResponse(){}

    public OrderWithItemsResponse(OrderResponse order, List<OrderItemResponse> orderItems) {
        this.order = order;
        this.orderItems = orderItems;
    }

    public OrderResponse getOrder() {
        return order;
    }

    public List<OrderItemResponse> getOrderItems() {
        return orderItems;
    }

    public void setOrder(OrderResponse order) {
        this.order = order;
    }

    public void setOrderItems(List<OrderItemResponse> orderItems) {
        this.orderItems = orderItems;
    }
}

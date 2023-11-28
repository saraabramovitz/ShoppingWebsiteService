package com.soppingWebsite.model;

public class OrderItemRequest {
        private Long userId;
        private Long itemId;

        public OrderItemRequest() {}

        public OrderItemRequest(Long userId, Long itemId) {
            this.userId = userId;
            this.itemId = itemId;
        }

        public Long getUserId() {
            return userId;
        }
        public Long getItemId() {
            return itemId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }
        public void setItemId(Long itemId) {
            this.itemId = itemId;
        }

}

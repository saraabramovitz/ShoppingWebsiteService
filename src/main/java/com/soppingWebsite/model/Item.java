package com.soppingWebsite.model;

public class Product {
    Long productId;
    String productName;
    String productImage;
    Double price;
    Long stock;

    public Product() {}

    public Product(Long productId, String productName, String productImage, Double price, Long stock) {
        this.productId = productId;
        this.productName = productName;
        this.productImage = productImage;
        this.price = price;
        this.stock = stock;
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public Double getPrice() {
        return price;
    }

    public Long getStock() {
        return stock;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }
}

package com.soppingWebsite.model;

public class Item {
    private Long itemId;
    private String itemName;
    private String itemImage;
    private String itemOverview;
    private String itemDetails;
    private String itemMeasurements;
    private Double price;
    private Long stock;

    public Item() {}

    public Item(Long itemId, String itemName, String itemImage, String itemOverview, String itemDetails, String itemMeasurements, Double price, Long stock) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemImage = itemImage;
        this.itemOverview = itemOverview;
        this.itemDetails = itemDetails;
        this.itemMeasurements = itemMeasurements;
        this.price = price;
        this.stock = stock;
    }

    public Long getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemImage() {
        return itemImage;
    }

    public String getItemOverview() {
        return itemOverview;
    }

    public String getItemDetails() {
        return itemDetails;
    }

    public String getItemMeasurements() {
        return itemMeasurements;
    }

    public Double getPrice() {
        return price;
    }

    public Long getStock() {
        return stock;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public void setItemOverview(String itemOverview) {
        this.itemOverview = itemOverview;
    }

    public void setItemDetails(String itemDetails) {
        this.itemDetails = itemDetails;
    }

    public void setItemMeasurements(String itemMeasurements) {
        this.itemMeasurements = itemMeasurements;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }
}

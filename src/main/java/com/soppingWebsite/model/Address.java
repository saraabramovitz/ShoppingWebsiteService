package com.soppingWebsite.model;

public class Address {
    private String city;
    private String street;
    private Integer buildingNumber;
    private Integer apartment;

    public Address(){}

    public Address(String city, String street, Integer buildingNumber, Integer apartment) {
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public Integer getBuildingNumber() {
        return buildingNumber;
    }

    public Integer getApartment() {
        return apartment;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setBuildingNumber(Integer buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public void setApartment(Integer apartment) {
        this.apartment = apartment;
    }
}

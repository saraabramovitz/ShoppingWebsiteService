package com.soppingWebsite.model;

public class CustomUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Address address;
    private String username;
    private String password;

    public CustomUserRequest(String firstName, String lastName, String email, String phone, Address address, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.username = username;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Address getAddress() {
        return address;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CustomUser toCustomUser(){
        return new CustomUser(
                null,
                this.firstName,
                this.lastName,
                this.email,
                this.phone,
                this.address,
                this.username,
                this.password,
                "",
                ""
        );
    }
}
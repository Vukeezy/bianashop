package com.example.webshop.model;

import java.util.List;

public class Cart {

    private String fullName;
    private String address;
    private boolean delievery;
    private String email;
    private String phoneNumber;
    private double finalPrice;
    private List<CartItem> cartItemList;

    public Cart() {
    }

    public Cart(String fullName, String address, boolean delievery, String email, String phoneNumber, double finalPrice, List<CartItem> cartItemList) {
        this.fullName = fullName;
        this.address = address;
        this.delievery = delievery;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.finalPrice = finalPrice;
        this.cartItemList = cartItemList;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isDelievery() {
        return delievery;
    }

    public void setDelievery(boolean delievery) {
        this.delievery = delievery;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

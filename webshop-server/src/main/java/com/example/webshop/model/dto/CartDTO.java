package com.example.webshop.model.dto;

import java.util.ArrayList;
import java.util.List;

public class CartDTO {

    private String fullName;
    private String address;
    private boolean delivery;
    private String email;
    private String phoneNumber;
    private List<CartItemDTO> items = new ArrayList<>();
    private double finalPrice;

    public CartDTO() {
    }

    public CartDTO(String fullName, String address, boolean delivery, String email, String phoneNumber, double finalPrice, List<CartItemDTO> cartItemList) {
        this.fullName = fullName;
        this.address = address;
        this.delivery = delivery;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.finalPrice = finalPrice;
        this.items = cartItemList;
    }

    public List<CartItemDTO> getItems() {
        return items;
    }

    public void setItems(List<CartItemDTO> items) {
        this.items = items;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
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

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

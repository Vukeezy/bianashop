package com.example.webshop.model.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderDTO {

    private int id;
    private String fullName;
    private String address;
    private boolean delievery;
    private String email;
    private String phoneNumber;
    private List<OrderedItemDTO> orderedItems = new ArrayList<>();
    private String status;
    private double finalPrice;

    public OrderDTO(int id, String fullName, String address, boolean delievery, String email, String phoneNumber, List<OrderedItemDTO> orderedItems, String status) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.fullName = fullName;
        this.address = address;
        this.delievery = delievery;
        this.email = email;
        this.orderedItems = orderedItems;
        this.status = status;
        this.finalPrice = 0.0;
        for(OrderedItemDTO dto: this.orderedItems) {
            this.finalPrice = this.finalPrice + (dto.getAmount() * dto.getPrice());
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<OrderedItemDTO> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(List<OrderedItemDTO> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public boolean isDelievery() {
        return delievery;
    }

    public void setDelievery(boolean delievery) {
        this.delievery = delievery;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

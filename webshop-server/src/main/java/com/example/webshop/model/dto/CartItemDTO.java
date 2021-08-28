package com.example.webshop.model.dto;

public class CartItemDTO {

    private int id;
    private int amount;

    public CartItemDTO() {
    }

    public CartItemDTO(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int itemId) {
        this.id = itemId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

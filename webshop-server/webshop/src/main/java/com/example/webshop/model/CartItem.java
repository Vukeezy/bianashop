package com.example.webshop.model;

public class CartItem {

    private int id;
    private int amount;

    public CartItem() {
    }

    public CartItem(int itemId, int amount) {
        this.id = itemId;
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

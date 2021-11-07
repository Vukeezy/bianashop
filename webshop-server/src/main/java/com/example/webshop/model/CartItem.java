package com.example.webshop.model;

public class CartItem {

    private int id;
    private int amount;
    private double width;
    private double height;
    private int maskId;
    private double price;

    public CartItem() {
    }

    public CartItem(int itemId, int amount) {
        this.id = itemId;
        this.amount = amount;
    }

    public CartItem(int id, int amount, double width, double height, int maskId) {
        this.id = id;
        this.amount = amount;
        this.width = width;
        this.height = height;
        this.maskId = maskId;
    }

    public CartItem(int id, int amount, double width, double height, int maskId, double price) {
        this.id = id;
        this.amount = amount;
        this.width = width;
        this.height = height;
        this.maskId = maskId;
        this.price = price;
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

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getMaskId() {
        return maskId;
    }

    public void setMaskId(int maskId) {
        this.maskId = maskId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

package com.example.webshop.model.dto;

public class OrderedItemDTO {

    private int id;
    private String itemCode;
    private String name;
    private String description;
    private double height;
    private double price;
    private int amount;
    private String picture;

    public OrderedItemDTO() {
    }

    public OrderedItemDTO(String itemCode, String name, double height, double price, int amount) {
        this.itemCode = itemCode;
        this.name = name;
        this.height = height;
        this.price = price;
        this.amount = amount;
    }

    public OrderedItemDTO(int id, String itemCode, String name, double height, double price, int amount) {
        this.id = id;
        this.itemCode = itemCode;
        this.name = name;
        this.height = height;
        this.price = price;
        this.amount = amount;
    }

    public OrderedItemDTO(int id, String itemCode, String name, double height, double price, int amount, String picture) {
        this.id = id;
        this.itemCode = itemCode;
        this.name = name;
        this.height = height;
        this.price = price;
        this.amount = amount;
        this.picture = picture;
    }

    public OrderedItemDTO(int id, String itemCode, String name, String description, double height, double price, int amount, String picture) {
        this.id = id;
        this.itemCode = itemCode;
        this.name = name;
        this.description = description;
        this.height = height;
        this.price = price;
        this.amount = amount;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package com.example.webshop.model;

import javax.persistence.*;

@Entity
@Table(name = "orderedItems")
public class OrderedItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "itemCode", nullable = false)
    private String itemCode;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "height", nullable = false)
    private double height;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "amount", nullable = false)
    private int amount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "picture_id", referencedColumnName = "id")
    private Picture picture;

    public OrderedItem() {
    }

    public OrderedItem(String itemCode, String name, double height, double price, int amount) {
        this.itemCode = itemCode;
        this.name = name;
        this.height = height;
        this.price = price;
        this.amount = amount;
    }

    public OrderedItem(int id, String itemCode, String name, double height, double price, int amount) {
        this.id = id;
        this.itemCode = itemCode;
        this.name = name;
        this.height = height;
        this.price = price;
        this.amount = amount;
    }

    public OrderedItem(String itemCode, String name, double height, double price, int amount, Picture picture) {
        this.itemCode = itemCode;
        this.name = name;
        this.height = height;
        this.price = price;
        this.amount = amount;
        this.picture = picture;
    }

    public OrderedItem(int id, String itemCode, String name, double height, double price, int amount, Picture picture) {
        this.id = id;
        this.itemCode = itemCode;
        this.name = name;
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

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}

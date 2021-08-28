package com.example.webshop.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "itemCode", unique = true, nullable = false)
    private String itemCode;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "height", unique = true, nullable = false)
    private double height;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "inStock", nullable = false)
    private int inStock;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sale_id", referencedColumnName = "id")
    private Sale sale;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "itemId")
    private Set<Picture> pictures = new HashSet<>();

    public Item() {
    }

    public Item(int id, String itemCode, String name, double height, double price) {
        this.id = id;
        this.itemCode = itemCode;
        this.name = name;
        this.height = height;
        this.price = price;
    }

    public Item(String itemCode, String name, double height, double price, Sale sale) {
        this.itemCode = itemCode;
        this.name = name;
        this.height = height;
        this.price = price;
        this.sale = sale;
    }

    public Item(int id, String itemCode, String name, double height, double price, Sale sale, int inStock) {
        this.id = id;
        this.itemCode = itemCode;
        this.name = name;
        this.height = height;
        this.price = price;
        this.sale = sale;
        this.inStock = inStock;
    }

    public Item(int id, String itemCode, String name, String description, double height, double price, int inStock, Sale sale, Set<Picture> pictures) {
        this.id = id;
        this.itemCode = itemCode;
        this.name = name;
        this.description = description;
        this.height = height;
        this.price = price;
        this.inStock = inStock;
        this.sale = sale;
        this.pictures = pictures;
    }

    public Item(int id, String itemCode, String name, String description, double height, double price, int inStock, Set<Picture> pictures) {
        this.id = id;
        this.itemCode = itemCode;
        this.name = name;
        this.description = description;
        this.height = height;
        this.price = price;
        this.inStock = inStock;
        this.pictures = pictures;
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

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Item){
            Item toCompare = (Item) o;
            return id == toCompare.getId();
        }
        return false;
    }
}

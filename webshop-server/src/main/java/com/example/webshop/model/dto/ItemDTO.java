package com.example.webshop.model.dto;

import java.util.ArrayList;
import java.util.List;

public class ItemDTO {

    private int id;
    private String itemCode;
    private String name;
    private String description;
    private double height;
    private double price;
    private SaleDTO sale;
    private int inStock;
    private List<String> pictures = new ArrayList<>();
    private String mainPicture;

    public ItemDTO() {
    }

    public ItemDTO(String itemCode, String name, double height, double price) {
        this.itemCode = itemCode;
        this.name = name;
        this.height = height;
        this.price = price;
    }

    public ItemDTO(int id, String itemCode, String name, double height, double price) {
        this.id = id;
        this.itemCode = itemCode;
        this.name = name;
        this.height = height;
        this.price = price;
    }

    public ItemDTO(String itemCode, String name, double height, double price, SaleDTO sale) {
        this.itemCode = itemCode;
        this.name = name;
        this.height = height;
        this.price = price;
        this.sale = sale;
    }

    public ItemDTO(int id, String itemCode, String name, double height, double price, SaleDTO sale, int inStock) {
        this.id = id;
        this.itemCode = itemCode;
        this.name = name;
        this.height = height;
        this.price = price;
        this.sale = sale;
        this.inStock = inStock;
    }

    public ItemDTO(int id, String itemCode, String name, double height, double price, SaleDTO sale, int inStock, List<String> pictures) {
        this.id = id;
        this.itemCode = itemCode;
        this.name = name;
        this.height = height;
        this.price = price;
        this.sale = sale;
        this.inStock = inStock;
        this.pictures = pictures;
    }

    public ItemDTO(int id, String itemCode, String name, String description, double height, double price, int inStock, List<String> pictures) {
        this.id = id;
        this.itemCode = itemCode;
        this.name = name;
        this.description = description;
        this.height = height;
        this.price = price;
        this.inStock = inStock;
        this.pictures = pictures;
    }

    public ItemDTO(int id, String itemCode, String name, String description, double height, double price, SaleDTO sale, int inStock, List<String> pictures) {
        this.id = id;
        this.itemCode = itemCode;
        this.name = name;
        this.description = description;
        this.height = height;
        this.price = price;
        this.sale = sale;
        this.inStock = inStock;
        this.pictures = pictures;
    }

    public ItemDTO(int id, String itemCode, String name, String description, double height, double price, SaleDTO sale, int inStock, List<String> pictures, String mainPicture) {
        this.id = id;
        this.itemCode = itemCode;
        this.name = name;
        this.description = description;
        this.height = height;
        this.price = price;
        this.sale = sale;
        this.inStock = inStock;
        this.pictures = pictures;
        this.mainPicture = mainPicture;
    }

    public ItemDTO(int id, String itemCode, String name, String description, double height, double price, int inStock, List<String> pictures, String mainPicture) {
        this.id = id;
        this.itemCode = itemCode;
        this.name = name;
        this.description = description;
        this.height = height;
        this.price = price;
        this.inStock = inStock;
        this.pictures = pictures;
        this.mainPicture = mainPicture;
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

    public SaleDTO getSale() {
        return sale;
    }

    public void setSale(SaleDTO sale) {
        this.sale = sale;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMainPicture() {
        return mainPicture;
    }

    public void setMainPicture(String mainPicture) {
        this.mainPicture = mainPicture;
    }
}

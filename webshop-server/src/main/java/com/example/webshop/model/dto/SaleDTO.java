package com.example.webshop.model.dto;

public class SaleDTO {

    private int id;
    private double percent;
    private int item;

    public SaleDTO() {
    }

    public SaleDTO(int id, double percent) {
        this.id = id;
        this.percent = percent;
    }

    public SaleDTO(double percent, int item) {
        this.percent = percent;
        this.item = item;
    }

    public SaleDTO(int id, double percent, int item) {
        this.id = id;
        this.percent = percent;
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }
}

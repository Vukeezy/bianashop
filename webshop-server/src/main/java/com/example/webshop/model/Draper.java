package com.example.webshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "drapers")
public class Draper extends Product { // draper

    // either one can be fixed or input

    @Column(name = "width")
    private double width;

    @Column(name = "height")
    private double height;

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

    @Override
    public double calculatePrice() {
        return 5000.0;
    }
}

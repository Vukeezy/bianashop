package com.example.webshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "furniture_fabrics")
public class FurnitureFabric extends Product { // mebl stof

    @Column(name = "height", nullable = false)
    private double height;

    private double width;

    @Column(name = "draper", nullable = false)
    private boolean draper;

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

    public boolean isDraper() {
        return draper;
    }

    public void setDraper(boolean draper) {
        this.draper = draper;
    }

    @Override
    public double calculatePrice() {
        return 6000.0;
    }
}

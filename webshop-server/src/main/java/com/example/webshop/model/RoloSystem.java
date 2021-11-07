package com.example.webshop.model;

import com.example.webshop.model.enums.RoloSystemType;

import javax.persistence.*;

@Entity
@Table(name = "rolo_systems")
public class RoloSystem extends Product {

    @Enumerated(EnumType.STRING)
    private RoloSystemType type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mask", referencedColumnName = "id")
    private Mask mask;

    private double height;
    private double width;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public RoloSystemType getType() {
        return type;
    }

    public void setType(RoloSystemType type) {
        this.type = type;
    }

    public Mask getMask() {
        return mask;
    }

    public void setMask(Mask mask) {
        this.mask = mask;
    }

    @Override
    public double calculatePrice() {
        return 9000.0;
    }
}

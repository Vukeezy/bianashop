package com.example.webshop.model;

import com.example.webshop.model.enums.CurtainType;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "curtains")
public class Curtain extends Product { // zavesa

    @Column(name = "height")
    private double height;

    @Transient
    @JsonProperty
    private double width;

    @Enumerated(EnumType.STRING)
    private CurtainType type;

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

    public CurtainType getType() {
        return type;
    }

    public void setType(CurtainType type) {
        this.type = type;
    }

    @Override
    public double calculatePrice() {
        return 2000.0;
    }
}

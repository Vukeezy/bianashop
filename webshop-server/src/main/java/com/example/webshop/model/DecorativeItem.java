package com.example.webshop.model;

import com.example.webshop.model.enums.DecorativeItemType;

import javax.persistence.*;

@Entity
@Table(name = "decorative_items")
public class DecorativeItem extends Product { // dekorativni predmet

    @Column(name = "width")
    private double width;

    @Column(name = "height")
    private double height;

    @Enumerated(EnumType.STRING)
    private DecorativeItemType type;

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

    public DecorativeItemType getType() {
        return type;
    }

    public void setType(DecorativeItemType type) {
        this.type = type;
    }

    @Override
    public double calculatePrice() {
        return 4000.0;
    }
}

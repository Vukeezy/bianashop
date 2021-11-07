package com.example.webshop.model;

import com.example.webshop.model.enums.MechanismType;

import javax.persistence.*;

@Entity
@Table(name = "mechanisms")
public class Mechanism extends Product {

    @Enumerated(EnumType.STRING)
    private MechanismType type;

    @Column(name = "number_of_pipes", nullable = false)
    private int numberOfPipes;

    private double width;
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

    public MechanismType getType() {
        return type;
    }

    public void setType(MechanismType type) {
        this.type = type;
    }

    public int getNumberOfPipes() {
        return numberOfPipes;
    }

    public void setNumberOfPipes(int numberOfPipes) {
        this.numberOfPipes = numberOfPipes;
    }

    @Override
    public double calculatePrice() {
        return 8000.0;
    }
}

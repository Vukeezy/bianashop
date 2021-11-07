package com.example.webshop.model;

import com.example.webshop.model.enums.CurtainRodType;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "curtain_rods")
public class CurtainRod extends Product { // garnisna

    @Enumerated(EnumType.STRING)
    private CurtainRodType type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mask", referencedColumnName = "id")
    private Mask mask;

    @Column(name = "number_of_pipes")
    private int numberOfPipes;

    @Transient
    @JsonProperty
    private double width;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public CurtainRodType getType() {
        return type;
    }

    public void setType(CurtainRodType type) {
        this.type = type;
    }

    public Mask getMask() {
        return mask;
    }

    public void setMask(Mask mask) {
        this.mask = mask;
    }

    public int getNumberOfPipes() {
        return numberOfPipes;
    }

    public void setNumberOfPipes(int numberOfPipes) {
        this.numberOfPipes = numberOfPipes;
    }

    @Override
    public double calculatePrice() {
        return 3000.0;
    }
}

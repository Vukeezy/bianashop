package com.example.webshop.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "masks")
public class Mask extends Product { // maska


    @Override
    public double calculatePrice() {
        return 7000.0;
    }
}

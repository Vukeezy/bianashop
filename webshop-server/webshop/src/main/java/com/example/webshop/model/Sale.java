package com.example.webshop.model;

import javax.persistence.*;

@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "percent", nullable = false)
    private double percent;

    public Sale() {
    }

    public Sale(int id, double percent) {
        this.id = id;
        this.percent = percent;
    }

    public Sale(double percent) {
        this.percent = percent;
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
}

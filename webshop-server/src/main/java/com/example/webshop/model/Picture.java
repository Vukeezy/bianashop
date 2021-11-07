package com.example.webshop.model;

import javax.persistence.*;

@Entity
@Table(name = "pictures")
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "picture_code", length = 1024024, nullable = false)
    private String pictureCode;

}

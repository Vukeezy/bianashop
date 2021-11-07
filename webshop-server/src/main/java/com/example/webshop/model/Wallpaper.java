package com.example.webshop.model;

import com.example.webshop.model.enums.WallpaperType;

import javax.persistence.*;

@Entity
@Table(name = "wallpapers")
public class Wallpaper extends Product { // tapeta

    @Column(name = "width", nullable = false)
    private double width;

    @Column(name = "height", nullable = false)
    private double height;

    @Enumerated(EnumType.STRING)
    private WallpaperType type;

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

    public WallpaperType getType() {
        return type;
    }

    public void setType(WallpaperType type) {
        this.type = type;
    }

    @Override
    public double calculatePrice() {
        return 10000.0;
    }
}

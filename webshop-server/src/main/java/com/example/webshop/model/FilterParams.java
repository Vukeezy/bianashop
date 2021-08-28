package com.example.webshop.model;

import com.example.webshop.model.dto.ItemDTO;

import java.util.List;

public class FilterParams {

    private List<ItemDTO> items;
    private double heightFrom;
    private double heightTo;
    private double priceFrom;
    private double priceTo;

    public FilterParams() {
    }

    public FilterParams(List<ItemDTO> items, double heightFrom, double heightTo, double priceFrom, double priceTo) {
        this.items = items;
        this.heightFrom = heightFrom;
        this.heightTo = heightTo;
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    public double getHeightFrom() {
        return heightFrom;
    }

    public void setHeightFrom(double heightFrom) {
        this.heightFrom = heightFrom;
    }

    public double getHeightTo() {
        return heightTo;
    }

    public void setHeightTo(double heightTo) {
        this.heightTo = heightTo;
    }

    public double getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(double priceFrom) {
        this.priceFrom = priceFrom;
    }

    public double getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(double priceTo) {
        this.priceTo = priceTo;
    }
}

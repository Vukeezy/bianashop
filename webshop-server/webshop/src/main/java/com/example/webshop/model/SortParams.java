package com.example.webshop.model;

import com.example.webshop.model.dto.ItemDTO;

import java.util.ArrayList;
import java.util.List;

public class SortParams {

    private String type; //asc or desc
    private String param;
    private List<ItemDTO> items = new ArrayList<>();

    public SortParams() {
    }

    public SortParams(String type, String param) {
        this.type = type;
        this.param = param;
    }

    public SortParams(String type, String param, List<ItemDTO> items) {
        this.type = type;
        this.param = param;
        this.items = items;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }
}

package com.example.webshop.model;

public class SearchParams {

    private String input;
    private String type;

    public SearchParams() {
    }

    public SearchParams(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

package com.example.webshop.exceptions;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {
        super("Artikal nije pronadjen!");
    }
}

package com.example.webshop.exceptions;

public class SaleNotFoundException extends RuntimeException {

    public SaleNotFoundException() {
        super("Akcija nije pronadjena!");
    }
}

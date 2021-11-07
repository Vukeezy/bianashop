package com.example.webshop.exceptions;

public class InvalidProductTypeException extends RuntimeException {

    public InvalidProductTypeException() {
        super("Prosledjeni tip artikla nije u redu!");
    }
}

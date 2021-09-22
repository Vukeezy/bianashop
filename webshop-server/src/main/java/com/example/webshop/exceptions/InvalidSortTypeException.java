package com.example.webshop.exceptions;

public class InvalidSortTypeException extends RuntimeException {

    public InvalidSortTypeException() {
        super("Tip sortiranja nije validan!");
    }
}

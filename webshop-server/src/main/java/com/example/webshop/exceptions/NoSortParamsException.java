package com.example.webshop.exceptions;

public class NoSortParamsException extends RuntimeException {

    public NoSortParamsException() {
        super("Parametri za sortiranje nisu poslati!");
    }
}

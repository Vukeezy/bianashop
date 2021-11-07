package com.example.webshop.exceptions;

public class MaskNotFoundException extends RuntimeException {

    public MaskNotFoundException() {
        super("Maska nije pronadjena!");
    }
}

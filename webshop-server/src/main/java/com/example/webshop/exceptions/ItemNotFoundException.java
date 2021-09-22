package com.example.webshop.exceptions;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException() {
        super("Artikal nije pronadjen!");
    }
}

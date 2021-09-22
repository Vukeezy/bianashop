package com.example.webshop.exceptions;

public class ItemUniqueNameException extends RuntimeException {

    public ItemUniqueNameException() {
        super("Artikal sa tim imenom vec postoji!");
    }
}

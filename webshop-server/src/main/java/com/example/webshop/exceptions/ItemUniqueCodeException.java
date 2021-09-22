package com.example.webshop.exceptions;

public class ItemUniqueCodeException extends RuntimeException {

    public ItemUniqueCodeException() {
        super("Artikal sa tom sifrom vec postoji!");
    }
}

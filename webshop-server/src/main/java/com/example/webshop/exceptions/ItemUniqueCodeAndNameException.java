package com.example.webshop.exceptions;

public class ItemUniqueCodeAndNameException extends RuntimeException {

    public ItemUniqueCodeAndNameException() {
        super("Artikal sa tim imenom i sifrom vec postoji!");
    }
}

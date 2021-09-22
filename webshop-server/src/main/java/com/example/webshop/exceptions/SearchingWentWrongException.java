package com.example.webshop.exceptions;

public class SearchingWentWrongException extends RuntimeException {

    public SearchingWentWrongException() {
        super("Nesto se desilo sa bazom podataka prilikom pretrazivanja. Molimo pokusajte ponovo kasnije!");
    }
}

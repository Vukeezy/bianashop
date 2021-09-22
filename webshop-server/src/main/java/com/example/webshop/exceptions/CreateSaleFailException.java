package com.example.webshop.exceptions;

public class CreateSaleFailException extends RuntimeException {

    public CreateSaleFailException() {
        super("Nesto se desilo sa bazom podataka prilikom kreiranja akcije. Molimo pokusajte ponovo kasnije!");
    }
}

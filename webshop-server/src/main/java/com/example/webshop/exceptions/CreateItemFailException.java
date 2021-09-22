package com.example.webshop.exceptions;

public class CreateItemFailException extends RuntimeException {

    public CreateItemFailException() {
        super("Nesto se desilo sa bazom podataka prilikom kreiranja artikla. Molimo pokusajte ponovo kasnije!");
    }
}

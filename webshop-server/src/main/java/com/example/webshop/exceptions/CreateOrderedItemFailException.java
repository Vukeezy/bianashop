package com.example.webshop.exceptions;

public class CreateOrderedItemFailException extends RuntimeException {

    public CreateOrderedItemFailException() {
        super("Nesto se desilo sa bazom podataka prilikom kreiranja artikla za porudzbinu. Molimo pokusajte ponovo kasnije!");
    }
}

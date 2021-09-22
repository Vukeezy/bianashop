package com.example.webshop.exceptions;

public class CreateOrderFailException extends RuntimeException {

    public CreateOrderFailException() {
        super("Nesto se desilo sa bazom podataka prilikom kreiranja porudzbine. Molimo pokusajte ponovo kasnije!");
    }
}

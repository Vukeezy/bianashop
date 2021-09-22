package com.example.webshop.exceptions;

public class CreateUserFailException extends RuntimeException {

    public CreateUserFailException() {
        super("Nesto se desilo sa bazom podataka prilikom registracije. Molimo pokusajte ponovo kasnije!");
    }
}

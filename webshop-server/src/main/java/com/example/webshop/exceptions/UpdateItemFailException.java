package com.example.webshop.exceptions;

public class UpdateItemFailException extends RuntimeException {

    public UpdateItemFailException() {
        super("Nesto se desilo sa bazom podataka prilikom azuriranja podataka za artikal. Molimo pokusajte ponovo kasnije!");
    }
}

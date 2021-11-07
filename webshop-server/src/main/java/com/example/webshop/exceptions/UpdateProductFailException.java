package com.example.webshop.exceptions;

public class UpdateProductFailException extends RuntimeException {

    public UpdateProductFailException() {
        super("Nesto se desilo sa bazom podataka prilikom azuriranja podataka za artikal. Molimo pokusajte ponovo kasnije!");
    }
}

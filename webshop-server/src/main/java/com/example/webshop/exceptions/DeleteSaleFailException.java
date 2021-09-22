package com.example.webshop.exceptions;

public class DeleteSaleFailException extends RuntimeException {

    public DeleteSaleFailException() {
        super("Nesto se desilo sa bazom prilikom brisanja akcije. Molimo pokusajte ponovo kasnije!");
    }
}

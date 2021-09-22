package com.example.webshop.exceptions;

public class NotUniqueCredentialsException extends RuntimeException {

    public NotUniqueCredentialsException() {
        super("Email i korisnicko ime moraju biti jedinstveni!");
    }
}

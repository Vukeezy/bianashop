package com.example.webshop.model.dto;

public class TokenDataDTO {

    private String token;

    public TokenDataDTO() {
    }

    public TokenDataDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

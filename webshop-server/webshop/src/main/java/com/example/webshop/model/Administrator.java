package com.example.webshop.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "administrators")
public class Administrator extends Person {

    public Administrator(){super();}

    public Administrator(Integer id, String username, String email, String password) {
        super(id, username, email, password);
    }

    public Administrator(String username, String email, String password) {
        super(username, email, password);
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return super.isVerified();
    }
}

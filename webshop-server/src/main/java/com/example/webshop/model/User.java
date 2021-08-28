package com.example.webshop.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends Person{

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

    public User() {
        super();
    }

    public User(Integer id, String username, String email, String password, Set<Order> orders) {
        super(id, username, email, password);
    }

    public User(String username, String email, String password, Set<Order> orders) {
        super(username, email, password);
    }

    public User(int id, String username, String email, String firstName, String lastName, String password, Set<Order> orders) {
        super(id, username, email, firstName, lastName, password);
    }

    public User(int id, String username, String email, String firstName, String lastName, String password) {
        super(id, username, email, firstName, lastName, password);
    }

    public User(Integer id, String username, String email, String password) {
        super(id, username, email, password);
    }

}

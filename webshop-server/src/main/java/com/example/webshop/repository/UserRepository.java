package com.example.webshop.repository;

import com.example.webshop.model.Authority;
import com.example.webshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsernameOrEmail(String username, String email);
    User findById(int id);
}

package com.example.webshop.repository;

import com.example.webshop.model.Administrator;
import com.example.webshop.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {

    Administrator findByUsernameOrEmail(String username, String email);
}

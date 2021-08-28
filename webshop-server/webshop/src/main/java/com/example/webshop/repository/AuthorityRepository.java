package com.example.webshop.repository;

import com.example.webshop.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

    Authority findById(int id);
}

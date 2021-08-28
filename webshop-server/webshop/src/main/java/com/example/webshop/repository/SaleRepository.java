package com.example.webshop.repository;

import com.example.webshop.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {

    Sale findById(int id);
}

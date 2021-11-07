package com.example.webshop.repository;

import com.example.webshop.model.Draper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DraperRepository extends JpaRepository<Draper, Integer> {

    Page<Draper> findByItemCodeOrNameContainsIgnoreCase(String input1, String input2, Pageable pageable);
}

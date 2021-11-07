package com.example.webshop.repository;

import com.example.webshop.model.Mask;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaskRepository extends JpaRepository<Mask, Integer> {

    Page<Mask> findByItemCodeOrNameContainsIgnoreCase(String input1, String input2, Pageable pageable);
    Mask findById(int id);
}

package com.example.webshop.repository;

import com.example.webshop.model.CurtainRod;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurtainRodRepository extends JpaRepository<CurtainRod, Integer> {

    Page<CurtainRod> findByItemCodeOrNameContainsIgnoreCase(String input1, String input2, Pageable pageable);
}

package com.example.webshop.service;

import com.example.webshop.model.CurtainRod;
import com.example.webshop.repository.CurtainRodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CurtainRodService {

    @Autowired
    CurtainRodRepository curtainRodRepository;

    public Page<CurtainRod> getAllByPage(Pageable pageable) {
        return curtainRodRepository.findAll(pageable);
    }

    public Page<CurtainRod> search(String input, Pageable pageable) {

        return curtainRodRepository.findByItemCodeOrNameContainsIgnoreCase(input, input, pageable);
    }
}

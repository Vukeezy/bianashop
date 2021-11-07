package com.example.webshop.service;

import com.example.webshop.model.Mechanism;
import com.example.webshop.repository.MechanismRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MechanismService {

    @Autowired
    MechanismRepository mechanismRepository;

    public Page<Mechanism> getAllByPage(Pageable pageable) {
        return mechanismRepository.findAll(pageable);
    }

    public Page<Mechanism> search(String input, Pageable pageable) {

        return mechanismRepository.findByItemCodeOrNameContainsIgnoreCase(input, input, pageable);
    }
}

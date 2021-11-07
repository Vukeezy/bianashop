package com.example.webshop.service;

import com.example.webshop.model.Curtain;
import com.example.webshop.model.Product;
import com.example.webshop.repository.CurtainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CurtainService {

    @Autowired
    CurtainRepository curtainRepository;

    public Page<Curtain> getAllByPage(Pageable pageable) {
        return curtainRepository.findAll(pageable);
    }

    public Page<Curtain> search(String input, Pageable pageable) {

        return curtainRepository.findByItemCodeOrNameContainsIgnoreCase(input, input, pageable);
    }
}

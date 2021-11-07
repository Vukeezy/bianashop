package com.example.webshop.service;

import com.example.webshop.model.Product;
import com.example.webshop.model.RoloSystem;
import com.example.webshop.repository.RoloSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RoloSystemService {

    @Autowired
    RoloSystemRepository roloSystemRepository;

    public Page<RoloSystem> getAllByPage(Pageable pageable) {
        return roloSystemRepository.findAll(pageable);
    }

    public Page<RoloSystem> search(String input, Pageable pageable) {

        return roloSystemRepository.findByItemCodeOrNameContainsIgnoreCase(input, input, pageable);
    }
}

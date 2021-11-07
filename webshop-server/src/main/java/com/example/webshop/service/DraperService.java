package com.example.webshop.service;

import com.example.webshop.model.Draper;
import com.example.webshop.model.Product;
import com.example.webshop.repository.DraperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DraperService {

    @Autowired
    DraperRepository draperRepository;

    public Page<Draper> getAllByPage(Pageable pageable) {
        return draperRepository.findAll(pageable);
    }

    public Page<Draper> search(String input, Pageable pageable) {

        return draperRepository.findByItemCodeOrNameContainsIgnoreCase(input, input, pageable);
    }
}

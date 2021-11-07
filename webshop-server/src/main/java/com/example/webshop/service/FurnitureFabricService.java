package com.example.webshop.service;

import com.example.webshop.model.FurnitureFabric;
import com.example.webshop.repository.FurnitureFabricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FurnitureFabricService {

    @Autowired
    FurnitureFabricRepository furnitureFabricRepository;

    public Page<FurnitureFabric> getAllByPage(Pageable pageable) {
        return furnitureFabricRepository.findAll(pageable);
    }

    public Page<FurnitureFabric> search(String input, Pageable pageable) {

        return furnitureFabricRepository.findByItemCodeOrNameContainsIgnoreCase(input, input, pageable);
    }
}

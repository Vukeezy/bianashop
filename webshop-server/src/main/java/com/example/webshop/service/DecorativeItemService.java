package com.example.webshop.service;

import com.example.webshop.model.DecorativeItem;
import com.example.webshop.repository.DecorativeItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DecorativeItemService {

    @Autowired
    DecorativeItemRepository decorativeItemRepository;

    public Page<DecorativeItem> getAllByPage(Pageable pageable) {
        return decorativeItemRepository.findAll(pageable);
    }

    public Page<DecorativeItem> search(String input, Pageable pageable) {

        return decorativeItemRepository.findByItemCodeOrNameContainsIgnoreCase(input, input, pageable);
    }
}

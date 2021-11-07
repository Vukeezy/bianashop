package com.example.webshop.service;

import com.example.webshop.exceptions.MaskNotFoundException;
import com.example.webshop.model.Mask;
import com.example.webshop.repository.MaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MaskService {

    @Autowired
    MaskRepository maskRepository;

    public Page<Mask> getAllByPage(Pageable pageable) {
        return maskRepository.findAll(pageable);
    }

    public Page<Mask> search(String input, Pageable pageable) {

        return maskRepository.findByItemCodeOrNameContainsIgnoreCase(input, input, pageable);
    }

    public Mask findById(int maskId) {

        Mask found = maskRepository.findById(maskId);
        if (found == null) {
            throw new MaskNotFoundException();
        }
        return found;
    }
}

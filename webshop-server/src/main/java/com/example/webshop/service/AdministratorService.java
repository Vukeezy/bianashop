package com.example.webshop.service;

import com.example.webshop.model.Administrator;
import com.example.webshop.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService {

    @Autowired
    AdministratorRepository administratorRepository;

    public Administrator findByUsernameOrEmail(String username, String email) {
        return administratorRepository.findByUsernameOrEmail(username, email);
    }
}

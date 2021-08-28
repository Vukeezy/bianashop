package com.example.webshop.service;

import com.example.webshop.model.Authority;
import com.example.webshop.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    public List<Authority> findById(int id) {
        List<Authority> auths = new ArrayList<>();
        Authority auth = this.authorityRepository.findById(id);
        if(auth != null)
            auths.add(auth);
        return auths;
    }
}

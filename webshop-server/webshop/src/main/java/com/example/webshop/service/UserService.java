package com.example.webshop.service;

import com.example.webshop.model.User;
import com.example.webshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findByUsernameOrEmail(String username, String email) {
        return userRepository.findByUsernameOrEmail(username, email);
    }

    public User registerUser(User existUser) {

        return userRepository.save(existUser);
    }

    public User findById(int id) {
        return userRepository.findById(id);
    }
}

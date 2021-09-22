package com.example.webshop.service;

import com.example.webshop.model.Picture;
import com.example.webshop.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureService {

    @Autowired
    PictureRepository pictureRepository;

    public Picture getByPicture(String picture) {
        return pictureRepository.findByPicture(picture);
    }
}

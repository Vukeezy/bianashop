package com.example.webshop.repository;

import com.example.webshop.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Integer> {

    Picture findByPicture(String picture);
}

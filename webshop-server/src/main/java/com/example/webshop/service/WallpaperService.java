package com.example.webshop.service;

import com.example.webshop.model.Wallpaper;
import com.example.webshop.repository.WallpaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class WallpaperService {

    @Autowired
    WallpaperRepository wallpaperRepository;

    public Page<Wallpaper> getAllByPage(Pageable pageable) {
        return wallpaperRepository.findAll(pageable);
    }

    public Page<Wallpaper> search(String input, Pageable pageable) {

        return wallpaperRepository.findByItemCodeOrNameContainsIgnoreCase(input, input, pageable);
    }
}

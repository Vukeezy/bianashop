package com.example.webshop.service;

import com.example.webshop.exceptions.InvalidProductTypeException;
import com.example.webshop.exceptions.ProductNotFoundException;
import com.example.webshop.exceptions.UpdateProductFailException;
import com.example.webshop.model.Product;
import com.example.webshop.model.SearchParams;
import com.example.webshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CurtainService curtainService;

    @Autowired
    CurtainRodService curtainRodService;

    @Autowired
    DecorativeItemService decorativeItemService;

    @Autowired
    DraperService draperService;

    @Autowired
    FurnitureFabricService furnitureFabricService;

    @Autowired
    MaskService maskService;

    @Autowired
    RoloSystemService roloSystemService;

    @Autowired
    WallpaperService wallpaperService;

    @Autowired
    MechanismService mechanismService;

    @Autowired
    PictureService pictureService;


    public Page<? extends Product> getAllByType(String type, Pageable pageable) {

        switch (type) {
            case "curtain":
                return curtainService.getAllByPage(pageable);
            case "curtain-rod":
                return curtainRodService.getAllByPage(pageable);
            case "decorative-item":
                return decorativeItemService.getAllByPage(pageable);
            case "draper":
                return draperService.getAllByPage(pageable);
            case "furniture-fabric":
                return furnitureFabricService.getAllByPage(pageable);
            case "mask":
                return maskService.getAllByPage(pageable);
            case "mechanism":
                return mechanismService.getAllByPage(pageable);
            case "rolo-system":
                return roloSystemService.getAllByPage(pageable);
            case "wallpaper":
                return wallpaperService.getAllByPage(pageable);
        }

        throw new InvalidProductTypeException();
    }

    public Page<? extends Product> search(SearchParams searchParams, Pageable pageable) {

        switch (searchParams.getType()) {
            case "curtain":
                return curtainService.search(searchParams.getInput(), pageable);
            case "curtain-rod":
                return curtainRodService.search(searchParams.getInput(), pageable);
            case "decorative-item":
                return decorativeItemService.search(searchParams.getInput(), pageable);
            case "draper":
                return draperService.search(searchParams.getInput(), pageable);
            case "furniture-fabric":
                return furnitureFabricService.search(searchParams.getInput(), pageable);
            case "mask":
                return maskService.search(searchParams.getInput(), pageable);
            case "mechanism":
                return mechanismService.search(searchParams.getInput(), pageable);
            case "rolo-system":
                return roloSystemService.search(searchParams.getInput(), pageable);
            case "wallpaper":
                return wallpaperService.search(searchParams.getInput(), pageable);
        }

        throw new InvalidProductTypeException();
    }

    public Product getById(int id) {
        Product found = productRepository.findById(id);
        if (found == null) {
            throw new ProductNotFoundException();
        }
        return found;
    }

    public Product update(Product product) {
        try {
            return productRepository.save(product);
        } catch (Exception e) {
            throw new UpdateProductFailException();
        }
    }
}

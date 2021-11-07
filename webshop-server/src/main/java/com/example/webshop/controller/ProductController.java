package com.example.webshop.controller;

import com.example.webshop.model.Product;
import com.example.webshop.model.SearchParams;
import com.example.webshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET, value = "{type}")
    public ResponseEntity<?> getAllProductsByType(@PathVariable String type, Pageable pageable) {
        Page<? extends Product> products = productService.getAllByType(type, pageable);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "search")
    public ResponseEntity<?> searchProducts(@RequestBody SearchParams params, Pageable pageable) {
        Page<? extends Product> searchResult = productService.search(params, pageable);
        return new ResponseEntity<>(searchResult, HttpStatus.OK);
    }
}

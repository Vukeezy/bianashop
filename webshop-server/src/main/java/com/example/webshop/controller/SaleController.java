package com.example.webshop.controller;

import com.example.webshop.mappers.SaleMapper;
import com.example.webshop.model.Sale;
import com.example.webshop.model.dto.SaleDTO;
import com.example.webshop.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/sales", produces = MediaType.APPLICATION_JSON_VALUE)
public class SaleController {

    @Autowired
    SaleService saleService;

    @Autowired
    SaleMapper saleMapper;

    @RequestMapping(method = RequestMethod.POST)
    // @PreAuthorize("hasRole('ROLE_ADMINISTRATOR')")
    public ResponseEntity<SaleDTO> createSale(@RequestBody SaleDTO saleDTO) {
        Sale result = saleService.create(saleMapper.toEntity(saleDTO), saleDTO.getItem());
        return new ResponseEntity<>(saleMapper.toDTO(result), HttpStatus.OK);
    }

    @RequestMapping(value = "/{saleId}", method = RequestMethod.DELETE)
    // @PreAuthorize("hasRole('ROLE_ADMINISTRATOR')")
    public ResponseEntity<?> deleteSale(@PathVariable int saleId) {
        saleService.delete(saleId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

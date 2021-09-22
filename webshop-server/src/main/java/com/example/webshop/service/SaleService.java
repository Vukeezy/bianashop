package com.example.webshop.service;

import com.example.webshop.exceptions.*;
import com.example.webshop.model.Item;
import com.example.webshop.model.Sale;
import com.example.webshop.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {

    @Autowired
    SaleRepository saleRepository;

    @Autowired
    ItemService itemService;

    public Sale create(Sale toEntity, int item) {

        Item foundItem = itemService.findById(item);

        if (foundItem == null) {
            throw new ItemNotFoundException();
        }

        try {
            Sale created = saleRepository.save(toEntity);

            if (foundItem.getSale() != null) {
                Sale toDelete = foundItem.getSale();
                foundItem.setSale(created);
                itemService.update(foundItem);
                saleRepository.delete(toDelete);

            } else {
                foundItem.setSale(created);
                itemService.update(foundItem);
            }

            return created;
        } catch (Exception e) {
            throw new CreateSaleFailException();
        }

    }

    public boolean delete(int saleId) {
        Sale found = saleRepository.findById(saleId);
        if (found == null) {
            throw new SaleNotFoundException();
        }

        Item findBySale = itemService.findBySaleId(saleId);
        findBySale.setSale(null);
        itemService.update(findBySale);
        try {
            saleRepository.delete(found);
            return true;
        } catch (Exception e) {
            throw new DeleteSaleFailException();
        }
    }
}

package com.example.webshop.service;

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
            return null;
        }

        Sale created = saleRepository.save(toEntity);

        if (foundItem.getSale() != null) {
            Sale toDelete = foundItem.getSale();
            foundItem.setSale(created);
            Item updated = itemService.update(foundItem);
            if(updated == null) {
                return null;
            }

            saleRepository.delete(toDelete);

        } else {
            foundItem.setSale(created);
            Item updated = itemService.update(foundItem);
            if(updated == null) {
                return null;
            }
        }

        return created;

    }

    public boolean delete(int saleId) {
        Sale found = saleRepository.findById(saleId);
        if (found == null) {
            return false;
        }

        Item findBySale = itemService.findBySaleId(saleId);
        findBySale.setSale(null);
        itemService.update(findBySale);
        saleRepository.delete(found);
        return true;
    }
}

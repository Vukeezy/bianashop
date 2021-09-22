package com.example.webshop.service;

import com.example.webshop.exceptions.CreateOrderedItemFailException;
import com.example.webshop.model.OrderedItem;
import com.example.webshop.model.Picture;
import com.example.webshop.repository.OrderedItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderedItemService {

    @Autowired
    OrderedItemRepository orderedItemRepository;

    @Autowired
    PictureService pictureService;

    public OrderedItem create(OrderedItem orderedItem) {

        Picture foundPicture = pictureService.getByPicture(orderedItem.getPicture().getPicture());
        if (foundPicture != null) {
            orderedItem.setPicture(foundPicture);
        }

        try {
            return orderedItemRepository.save(orderedItem);
        } catch (Exception e) {
            throw new CreateOrderedItemFailException();
        }
    }
}

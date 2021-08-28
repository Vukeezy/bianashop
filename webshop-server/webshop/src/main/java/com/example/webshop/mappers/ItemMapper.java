package com.example.webshop.mappers;

import com.example.webshop.model.Item;
import com.example.webshop.model.Picture;
import com.example.webshop.model.dto.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class ItemMapper implements MapperInterface<Item, ItemDTO> {

    @Autowired
    SaleMapper saleMapper;

    @Autowired
    PictureMapper pictureMapper;

    @Override
    public Item toEntity(ItemDTO dto) {
        if (dto.getSale() != null) {
            return new Item(dto.getId(), dto.getItemCode(), dto.getName(), dto.getDescription(), dto.getHeight(), dto.getPrice(), dto.getInStock(), saleMapper.toEntity(dto.getSale()), (Set<Picture>) pictureMapper.toEntitySet(dto.getPictures()));
        }
        return new Item(dto.getId(), dto.getItemCode(), dto.getName(), dto.getDescription(), dto.getHeight(), dto.getPrice(), dto.getInStock(), (Set<Picture>) pictureMapper.toEntitySet(dto.getPictures()));

    }

    @Override
    public ItemDTO toDTO(Item entity) {
        if (entity.getSale() != null) {
            return new ItemDTO(entity.getId(), entity.getItemCode(), entity.getName(), entity.getDescription(), entity.getHeight(), entity.getPrice(), saleMapper.toDTO(entity.getSale()), entity.getInStock(), pictureMapper.toDTOSet(entity.getPictures()));
        }
        return new ItemDTO(entity.getId(), entity.getItemCode(), entity.getName(), entity.getDescription(), entity.getHeight(), entity.getPrice(), entity.getInStock(), pictureMapper.toDTOSet(entity.getPictures()));
    }

    @Override
    public List<Item> toEntityList(List<ItemDTO> dtos) {
        List<Item> toReturn = new ArrayList<>();
        for(ItemDTO dto : dtos) {
            toReturn.add(this.toEntity(dto));
        }
        return toReturn;
    }

    @Override
    public List<ItemDTO> toDTOList(List<Item> entities) {
        List<ItemDTO> toReturn = new ArrayList<>();
        for(Item item : entities) {
            toReturn.add(this.toDTO(item));
        }
        return toReturn;
    }
}

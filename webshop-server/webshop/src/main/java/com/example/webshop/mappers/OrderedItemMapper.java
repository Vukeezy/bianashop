package com.example.webshop.mappers;

import com.example.webshop.model.OrderedItem;
import com.example.webshop.model.dto.OrderedItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class OrderedItemMapper implements MapperInterface<OrderedItem, OrderedItemDTO> {

    @Autowired
    PictureMapper pictureMapper;

    @Override
    public OrderedItem toEntity(OrderedItemDTO dto) {
        return new OrderedItem(dto.getId(), dto.getItemCode(), dto.getName(), dto.getHeight(), dto.getPrice(), dto.getAmount(), pictureMapper.toEntity(dto.getPicture()));
    }

    @Override
    public OrderedItemDTO toDTO(OrderedItem entity) {
        return new OrderedItemDTO(entity.getId(), entity.getItemCode(), entity.getName(), entity.getHeight(), entity.getPrice(), entity.getAmount(), pictureMapper.toDTO(entity.getPicture()));
    }

    @Override
    public List<OrderedItem> toEntityList(List<OrderedItemDTO> dtos) {
        List<OrderedItem> toReturn = new ArrayList<>();
        for(OrderedItemDTO dto : dtos) {
            toReturn.add(this.toEntity(dto));
        }
        return toReturn;
    }


    public Set<OrderedItem> toEntitySet(List<OrderedItemDTO> dtos) {
        Set<OrderedItem> toReturn = new HashSet<>();
        for(OrderedItemDTO dto : dtos) {
            toReturn.add(this.toEntity(dto));
        }
        return toReturn;
    }

    @Override
    public List<OrderedItemDTO> toDTOList(List<OrderedItem> entities) {
        List<OrderedItemDTO> toReturn = new ArrayList<>();
        for(OrderedItem item : entities) {
            toReturn.add(this.toDTO(item));
        }
        return toReturn;
    }
}

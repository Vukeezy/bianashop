package com.example.webshop.mappers;

import com.example.webshop.model.CartItem;
import com.example.webshop.model.dto.CartItemDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartItemMapper implements MapperInterface<CartItem, CartItemDTO> {

    @Override
    public CartItem toEntity(CartItemDTO dto) {
        return new CartItem(dto.getId(), dto.getAmount());
    }

    @Override
    public CartItemDTO toDTO(CartItem entity) {
        return null;
    }

    @Override
    public List<CartItem> toEntityList(List<CartItemDTO> dtos) {
        List<CartItem> items = new ArrayList<>();
        for(CartItemDTO dto: dtos) {
            items.add(this.toEntity(dto));
        }
        return items;
    }

    @Override
    public List<CartItemDTO> toDTOList(List<CartItem> entities) {
        return null;
    }
}

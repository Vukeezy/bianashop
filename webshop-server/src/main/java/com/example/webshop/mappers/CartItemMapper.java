package com.example.webshop.mappers;

import com.example.webshop.model.CartItem;
import com.example.webshop.model.dto.CartItemDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class CartItemMapper implements MapperInterface<CartItem, CartItemDTO> {

    @Override
    public CartItem toEntity(CartItemDTO dto) {
        return new CartItem(dto.getId(), dto.getAmount(), dto.getWidth(), dto.getHeight(), dto.getMaskId(), dto.getPrice());
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

    @Override
    public Set<CartItem> toEntitySet(List<CartItemDTO> dtos) {
        return null;
    }

    @Override
    public List<CartItemDTO> toDTOList(Set<CartItem> entities) {
        return null;
    }
}

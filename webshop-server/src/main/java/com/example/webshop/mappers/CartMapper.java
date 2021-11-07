package com.example.webshop.mappers;

import com.example.webshop.model.Cart;
import com.example.webshop.model.dto.CartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class CartMapper implements MapperInterface<Cart, CartDTO> {

    @Autowired
    CartItemMapper cartItemMapper;

    @Override
    public Cart toEntity(CartDTO dto) {
        return new Cart(dto.getFullName(), dto.getAddress(), dto.isDelivery(), dto.getEmail(), dto.getPhoneNumber(), dto.getFinalPrice(), cartItemMapper.toEntityList(dto.getItems()));
    }

    @Override
    public CartDTO toDTO(Cart entity) {
        return null;
    }

    @Override
    public List<Cart> toEntityList(List<CartDTO> dtos) {
        return null;
    }

    @Override
    public List<CartDTO> toDTOList(List<Cart> entities) {
        return null;
    }

    @Override
    public Set<Cart> toEntitySet(List<CartDTO> dtos) {
        return null;
    }

    @Override
    public List<CartDTO> toDTOList(Set<Cart> entities) {
        return null;
    }
}

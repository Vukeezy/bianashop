package com.example.webshop.mappers;

import com.example.webshop.model.Order;
import com.example.webshop.model.OrderedItem;
import com.example.webshop.model.dto.OrderDTO;
import com.example.webshop.model.enums.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class OrderMapper implements MapperInterface<Order, OrderDTO> {

    @Autowired
    UserMapper userMapper;

    @Autowired
    OrderedItemMapper orderedItemMapper;

    @Override
    public Order toEntity(OrderDTO dto) {
        return new Order(dto.getId(), dto.getFullName(), dto.getAddress(), dto.getEmail(), dto.isDelievery(), dto.getPhoneNumber(),
                orderedItemMapper.toEntitySet(dto.getOrderedItems()), OrderStatus.valueOf(dto.getStatus()));
    }

    @Override
    public OrderDTO toDTO(Order entity) {
        return new OrderDTO(entity.getId(), entity.getFullName(), entity.getAddress(), entity.isDelievery(), entity.getEmail(), entity.getPhoneNumber(),
                orderedItemMapper.toDTOList(this.toEntityList(entity.getOrderedItems())), entity.getStatus().toString());
    }

    @Override
    public List<Order> toEntityList(List<OrderDTO> dtos) {
        List<Order> toReturn = new ArrayList<>();
        for(OrderDTO dto : dtos) {
            toReturn.add(this.toEntity(dto));
        }
        return toReturn;
    }

    public List<OrderedItem> toEntityList(Set<OrderedItem> dtos) {
        return new ArrayList<>(dtos);
    }

    public Set<Order> toEntitySet(List<OrderDTO> dtos) {
        Set<Order> toReturn = new HashSet<>();
        for (OrderDTO dto : dtos) {
            toReturn.add(this.toEntity(dto));
        }
        return toReturn;
    }

    @Override
    public List<OrderDTO> toDTOList(List<Order> entities) {
        List<OrderDTO> toReturn = new ArrayList<>();
        for(Order order : entities) {
            toReturn.add(this.toDTO(order));
        }
        return toReturn;
    }
}

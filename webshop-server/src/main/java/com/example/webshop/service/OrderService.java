package com.example.webshop.service;

import com.example.webshop.model.*;
import com.example.webshop.model.dto.CartItemDTO;
import com.example.webshop.model.enums.OrderStatus;
import com.example.webshop.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserService userService;

    @Autowired
    ItemService itemService;

    @Autowired
    OrderedItemService orderedItemService;


    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order create(Cart toEntity) {

        List<Item> foundItems = new ArrayList<>();
        for (CartItem cartItem: toEntity.getCartItemList()) {
            Item found = itemService.findById(cartItem.getId());
            if (found == null) {
                return null;
            }
            foundItems.add(found);
        }

        Set<OrderedItem> orderedItems = new HashSet<>();
        for (Item item: foundItems) {
            OrderedItem orderedItem = new OrderedItem(item.getItemCode(), item.getName(), item.getHeight(), item.getPrice(),
                    toEntity.getCartItemList().get(foundItems.indexOf(item)).getAmount(), item.getMainPicture());
            orderedItem = orderedItemService.create(orderedItem);
            orderedItems.add(orderedItem);
            item.setInStock(item.getInStock() - orderedItem.getAmount());
            itemService.update(item);
        }

        Order newOrder = new Order(toEntity.getFullName(), toEntity.getAddress(), toEntity.getEmail(), toEntity.isDelievery(), toEntity.getPhoneNumber(), orderedItems, OrderStatus.SENT);
        newOrder = orderRepository.save(newOrder);
        return newOrder;

    }
}

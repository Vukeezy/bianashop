package com.example.webshop.service;

import com.example.webshop.exceptions.CreateOrderFailException;
import com.example.webshop.model.*;
import com.example.webshop.model.enums.OrderStatus;
import com.example.webshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductService productService;

    @Autowired
    MaskService maskService;

    public List<Order> getAll() {
        return null; // orderRepository.findAll();
    }

    public Order create(Cart cart) {

        List<Product> foundProducts = new ArrayList<>();
        for (CartItem cartItem: cart.getCartItemList()) {
            Product found = productService.getById(cartItem.getId());
            foundProducts.add(found);
        }

        Set<OrderedItem> orderedItems = new HashSet<>();
        for (Product product: foundProducts) {
            int productIndex = foundProducts.indexOf(product);
            CartItem cartItem = cart.getCartItemList().get(productIndex);
            OrderedItem orderedItem;
            if (cartItem.getMaskId() != -1) {
                Mask foundMask = maskService.findById(cartItem.getMaskId());
                orderedItem = new OrderedItem(product, cartItem, foundMask);
            } else {
                orderedItem = new OrderedItem(product, cartItem);
            }
            orderedItems.add(orderedItem);
            product.setInStock(product.getInStock() - orderedItem.getAmount());
            productService.update(product);
        }

        Order newOrder = new Order(cart.getFullName(), cart.getAddress(), cart.getEmail(), cart.getPhoneNumber(), orderedItems, cart.isDelivery(), OrderStatus.SENT, cart.getFinalPrice(), new Date());
        try {
            return orderRepository.save(newOrder);
        } catch (Exception e) {
            throw new CreateOrderFailException();
        }
    }

    public Cart calculateCartPrice(Cart cart) {

        double price = 0.0;

        for (CartItem cartItem: cart.getCartItemList()) {
            Product product = productService.getById(cartItem.getId());

            if (product instanceof Curtain) {
                ((Curtain) product).setWidth(cartItem.getWidth());
            } else if (product instanceof CurtainRod) {
                ((CurtainRod) product).setWidth(cartItem.getWidth());
                ((CurtainRod) product).setMask(maskService.findById(cartItem.getMaskId()));
            } else if (product instanceof Draper) {
                if (((Draper) product).getHeight() == 0) {
                    ((Draper) product).setHeight(cartItem.getHeight());
                } else {
                    ((Draper) product).setWidth(cartItem.getWidth());
                }
            } else if (product instanceof FurnitureFabric) {
                ((FurnitureFabric) product).setWidth(cartItem.getWidth());
            } else if (product instanceof Mechanism) {
                ((Mechanism) product).setHeight(cartItem.getHeight());
                ((Mechanism) product).setWidth(cartItem.getWidth());
            } else if (product instanceof RoloSystem) {
                ((RoloSystem) product).setHeight(cartItem.getHeight());
                ((RoloSystem) product).setWidth(cartItem.getWidth());
                ((RoloSystem) product).setMask(maskService.findById(cartItem.getMaskId()));
            } // wallpaper, mask, decorative item don't need changes

            double itemPrice = product.calculatePrice();
            price += itemPrice;
            cartItem.setPrice(itemPrice);
        }
        cart.setFinalPrice(price);
        return cart;
    }
}

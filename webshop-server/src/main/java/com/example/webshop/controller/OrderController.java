package com.example.webshop.controller;

import com.example.webshop.mappers.CartMapper;
import com.example.webshop.model.Cart;
import com.example.webshop.model.Curtain;
import com.example.webshop.model.CurtainRod;
import com.example.webshop.model.Order;
import com.example.webshop.model.dto.CartDTO;
import com.example.webshop.model.dto.OrderDTO;
import com.example.webshop.repository.CurtainRepository;
import com.example.webshop.repository.CurtainRodRepository;
import com.example.webshop.repository.OrderRepository;
import com.example.webshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    CartMapper cartMapper;

    @Autowired
    CurtainRepository curtainRepository;

    @Autowired
    CurtainRodRepository curtainRodRepository;

    @Autowired
    OrderRepository orderRepository;

    @RequestMapping(method = RequestMethod.GET)
    // @PreAuthorize("hasRole('ROLE_ADMINISTRATOR')")
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        List<Order> result = orderService.getAll();
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<OrderDTO> makeOrder(@RequestBody CartDTO cartDTO) {
        Order result = orderService.create(cartMapper.toEntity(cartDTO));
        return new ResponseEntity<>(null, HttpStatus.OK); // returns null bcs i don't have order mapper
    }

    @RequestMapping(value = "cart/calculate-price", method = RequestMethod.POST)
    public ResponseEntity<CartDTO> calculateCartPrice(@RequestBody CartDTO cartDTO) {
        Cart cart = orderService.calculateCartPrice(cartMapper.toEntity(cartDTO));
        return new ResponseEntity<>(cartMapper.toDTO(cart), HttpStatus.OK);
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public ResponseEntity<?> test() {
        curtainRepository.save(new Curtain());
        curtainRodRepository.save(new CurtainRod());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

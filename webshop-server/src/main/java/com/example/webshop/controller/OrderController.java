package com.example.webshop.controller;

import com.example.webshop.mappers.CartMapper;
import com.example.webshop.mappers.OrderMapper;
import com.example.webshop.mappers.UserMapper;
import com.example.webshop.model.Order;
import com.example.webshop.model.Person;
import com.example.webshop.model.dto.CartDTO;
import com.example.webshop.model.dto.OrderDTO;
import com.example.webshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    OrderMapper orderMapper;

    @Autowired
    CartMapper cartMapper;

    @Autowired
    UserMapper userMapper;

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMINISTRATOR')")
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        List<Order> result = orderService.getAll();
        return new ResponseEntity<>(orderMapper.toDTOList(result), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<OrderDTO> makeOrder(@RequestBody CartDTO cartDTO) {
        Order result = orderService.create(cartMapper.toEntity(cartDTO));
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(orderMapper.toDTO(result), HttpStatus.OK);
    }
}

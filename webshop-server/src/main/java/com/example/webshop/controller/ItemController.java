package com.example.webshop.controller;

import com.example.webshop.mappers.ItemMapper;
import com.example.webshop.model.FilterParams;
import com.example.webshop.model.Item;
import com.example.webshop.model.SearchParams;
import com.example.webshop.model.SortParams;
import com.example.webshop.model.dto.ItemDTO;
import com.example.webshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/items", produces = MediaType.APPLICATION_JSON_VALUE)
public class ItemController {

    @Autowired
    ItemService itemService;

    @Autowired
    ItemMapper itemMapper;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ItemDTO>> getAllItems() {
        List<Item> result = itemService.getAll();
        return new ResponseEntity<>(itemMapper.toDTOList(result), HttpStatus.OK);
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public ResponseEntity<?> getItemById(@RequestParam int id) {
        Item result = itemService.findById(id);
        return new ResponseEntity<>(itemMapper.toDTO(result), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    // @PreAuthorize("hasRole('ROLE_ADMINISTRATOR')")
    public ResponseEntity<ItemDTO> createNewItem(@RequestBody ItemDTO itemDTO) {
        Item result = itemService.create(itemMapper.toEntity(itemDTO));
        return new ResponseEntity<>(itemMapper.toDTO(result), HttpStatus.OK);
    }

    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public ResponseEntity<List<ItemDTO>> sortItems(@RequestBody SortParams sortParams) {
        List<Item> result = itemService.sort(sortParams, itemMapper.toEntityList(sortParams.getItems()));
        return new ResponseEntity<>(itemMapper.toDTOList(result), HttpStatus.OK);
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ResponseEntity<List<ItemDTO>> searchItems(@RequestBody SearchParams searchParams) {
        List<Item> result = itemService.search(searchParams);
        return new ResponseEntity<>(itemMapper.toDTOList(result), HttpStatus.OK);
    }

    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public ResponseEntity<List<ItemDTO>> filterItems(@RequestBody FilterParams filterParams) {
        List<Item> result = itemService.filter(filterParams, itemMapper.toEntityList(filterParams.getItems()));
        return new ResponseEntity<>(itemMapper.toDTOList(result), HttpStatus.OK);
    }
}

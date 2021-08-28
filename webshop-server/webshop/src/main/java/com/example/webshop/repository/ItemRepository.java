package com.example.webshop.repository;

import com.example.webshop.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    Item findById(int id);

    Item findByItemCodeOrName(String itemCode, String name);

    Item findBySaleId(int saleId);

    List<Item> findByItemCodeOrNameContains(String input1, String input2);
}

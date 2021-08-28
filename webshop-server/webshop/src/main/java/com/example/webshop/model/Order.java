package com.example.webshop.model;

import com.example.webshop.model.dto.OrderedItemDTO;
import com.example.webshop.model.enums.OrderStatus;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fullName", nullable = false)
    private String fullName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "delievery", nullable = false)
    private boolean delievery;

    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "orderId")
    private Set<OrderedItem> orderedItems = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "finalPrice", nullable = false)
    private double finalPrice;

    public Order() {
    }

    public Order(String fullName, String address, String email, boolean delievery, String phoneNumber, Set<OrderedItem> orderedItems, OrderStatus status) {
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.delievery = delievery;
        this.phoneNumber = phoneNumber;
        this.orderedItems = orderedItems;
        this.status = status;
        this.finalPrice = 0.0;
        calculateFinalPrice();
    }

    public Order(int id,String fullName, String address, String email, boolean delievery, String phoneNumber, Set<OrderedItem> orderedItems, OrderStatus status) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.delievery = delievery;
        this.phoneNumber = phoneNumber;
        this.orderedItems = orderedItems;
        this.status = status;
        this.finalPrice = 0.0;
        calculateFinalPrice();
    }

    private void calculateFinalPrice() {
        for(OrderedItem item: this.orderedItems) {
            this.finalPrice = this.finalPrice + (item.getAmount() * item.getPrice());
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<OrderedItem> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(Set<OrderedItem> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isDelievery() {
        return delievery;
    }

    public void setDelievery(boolean delievery) {
        this.delievery = delievery;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

package com.example.webshop.model;

import com.example.webshop.model.enums.OrderStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "orderId")
    private Set<OrderedItem> orderedItems = new HashSet<>();

    @Column(name = "delivery")
    private boolean delivery;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "finalPrice")
    private double finalPrice;

    @Column(name = "orderDate")
    private Date orderDate;

    public Order() {
    }

    public Order(String fullName, String address, String email, String phoneNumber, Set<OrderedItem> orderedItems, boolean delivery, OrderStatus status, double finalPrice, Date orderDate) {
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.orderedItems = orderedItems;
        this.delivery = delivery;
        this.status = status;
        this.finalPrice = finalPrice;
        this.orderDate = orderDate;
    }

    public Order(int id, String fullName, String address, String email, String phoneNumber, Set<OrderedItem> orderedItems, boolean delivery, OrderStatus status, double finalPrice, Date orderDate) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.orderedItems = orderedItems;
        this.delivery = delivery;
        this.status = status;
        this.finalPrice = finalPrice;
        this.orderDate = orderDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<OrderedItem> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(Set<OrderedItem> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
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

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    private void calculateFinalPrice() {
        for(OrderedItem item: this.orderedItems) {
            // this.finalPrice = this.finalPrice + (item.getAmount() * item.getPrice());
        }
        this.finalPrice = 20.0;
    }

}

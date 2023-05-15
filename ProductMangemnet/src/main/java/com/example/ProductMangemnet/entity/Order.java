package com.example.ProductMangemnet.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PlaceOrder_tb")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "Customer_id",referencedColumnName = "id")
    private Customer customer;

    @OneToMany(fetch = FetchType.EAGER,cascade =CascadeType.ALL,targetEntity = Cart.class)
    @JoinColumn(name="order_id",referencedColumnName = "id")
    private List<Cart> CartItems;

    public Order(Customer customer, List<Cart> cartItems) {
        this.customer = customer;
        CartItems = cartItems;
    }

    public Order() {
    }

}

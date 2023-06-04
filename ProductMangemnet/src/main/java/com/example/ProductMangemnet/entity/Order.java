package com.example.ProductMangemnet.entity;

import com.example.ProductMangemnet.dto.OrderDTO;
import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
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



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Customer_id",referencedColumnName = "id")
    private Customer customer;

    @OneToMany(fetch = FetchType.EAGER,cascade =CascadeType.ALL,targetEntity = Cart.class)
    @JoinColumn(name="order_id",referencedColumnName = "id")
    private List<Cart> CartItems;

    private float totalAmount;

    private Date createOrderDate = new java.sql.Date(new java.util.Date().getTime());
    public Order(Customer customer, List<Cart> cartItems,float totalAmount) {
        this.totalAmount=totalAmount;
        this.customer = customer;
        CartItems = cartItems;
    }

    public Order() {
    }

}

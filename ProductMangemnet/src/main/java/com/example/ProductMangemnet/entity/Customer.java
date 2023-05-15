package com.example.ProductMangemnet.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customer_tb")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String name;
    private String contactNo;

    private String city;

    private String address;


    public Customer(String email, String name, String contactNo, String city, String address) {
        this.email = email;
        this.name = name;
        this.contactNo = contactNo;
        this.city = city;
        this.address = address;
    }
}

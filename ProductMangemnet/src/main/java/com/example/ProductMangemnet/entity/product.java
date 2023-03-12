package com.example.ProductMangemnet.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Product_tb")
public class product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String title;
    private String price;
    private String imgpath;

    private String category;

}

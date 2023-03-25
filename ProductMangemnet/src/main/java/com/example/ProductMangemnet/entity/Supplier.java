package com.example.ProductMangemnet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Supplier_tb")
public class Supplier {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int supplier_id;
    private String supplier_name;
    private String supplier_address;


}

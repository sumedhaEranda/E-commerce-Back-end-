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
@Table(name = "Category_tb")
public class Category {

        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private int category_id;
        private String Category_name;


}

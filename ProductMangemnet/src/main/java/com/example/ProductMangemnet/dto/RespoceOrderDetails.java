package com.example.ProductMangemnet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class RespoceOrderDetails {
    private int pid;
    private String category;
    private String title;
    private float price;
    private String imgpath;
    private int quantity;

    private float totalamount;

    public RespoceOrderDetails() {

    }


}

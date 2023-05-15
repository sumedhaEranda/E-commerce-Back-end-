package com.example.ProductMangemnet.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CartItemDTO {
    private String title;
    private int quantity;


    public CartItemDTO(String title, int quantity) {
        this.title = title;
        this.quantity = quantity;
    }

}

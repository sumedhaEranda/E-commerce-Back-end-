package com.example.ProductMangemnet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class GetSalesOrder {

    private String id;
    private List<Data> data;

    public GetSalesOrder() {

    }
}


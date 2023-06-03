package com.example.ProductMangemnet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class GetCategoryItems {
private  long value;
private  String label;
private  String id;

    public GetCategoryItems() {

    }
}

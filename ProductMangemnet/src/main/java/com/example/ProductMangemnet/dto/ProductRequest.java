package com.example.ProductMangemnet.dto;

import com.example.ProductMangemnet.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductRequest {
  private Category category;
}

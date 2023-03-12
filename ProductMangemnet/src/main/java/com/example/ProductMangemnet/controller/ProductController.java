package com.example.ProductMangemnet.controller;

import com.example.ProductMangemnet.entity.product;
import com.example.ProductMangemnet.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    // Get All products
    @GetMapping("/all")
    public List<product> getAllNotes()
    {
        return productService.GetAllProducts();
    }

}

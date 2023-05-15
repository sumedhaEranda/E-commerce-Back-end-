package com.example.ProductMangemnet.controller;

import com.example.ProductMangemnet.entity.Product;
import com.example.ProductMangemnet.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/product")
@RestController
public class ProductController {

    @Autowired
    ProductService productService;


    // Get All products
    @GetMapping("/all")
    public List<Product> getAllNotes()
    {
        return productService.GetAllProducts();
    }

    @PostMapping("/AddProduct")
    public ResponseEntity<Product> postBody(@RequestBody Product product) {

        Product prodt=  productService.saveProductData(product);
        return ResponseEntity.ok(prodt);
    }

}

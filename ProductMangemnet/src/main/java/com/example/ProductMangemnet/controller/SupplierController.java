package com.example.ProductMangemnet.controller;

import com.example.ProductMangemnet.entity.Supplier;
import com.example.ProductMangemnet.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/product/supllier")
public class SupplierController {

    @Autowired
    private ProductService productService;
    // Get All products

}

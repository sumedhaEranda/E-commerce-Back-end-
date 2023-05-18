package com.example.ProductMangemnet.controller;

import com.example.ProductMangemnet.entity.Customer;
import com.example.ProductMangemnet.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @GetMapping(value = "/getAll")
    public  List<Customer>getAllUser() {

        return customerService.GetAllProducts();
    }
}

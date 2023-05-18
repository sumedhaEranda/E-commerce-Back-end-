package com.example.ProductMangemnet.service;


import com.example.ProductMangemnet.entity.Product;
import com.example.ProductMangemnet.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    //GET ALL GetAllProducts  according to product
    public List<Product> GetAllProducts() {
        return  productRepo.findAll();
    }
    public Product saveProductData( Product product){
           Product prodctinfo=productRepo.save(product);

        return product;
    }

    public boolean checkProductNameExists(String productName) {
        return productRepo.existsByTitle(productName);
    }
}

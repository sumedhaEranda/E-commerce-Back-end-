package com.example.ProductMangemnet.service;

import com.example.ProductMangemnet.entity.product;
import com.example.ProductMangemnet.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ProductService {

@Autowired
private ProductRepository productRepo;


    //GET ALL GetAllProducts  according to product
    public List<product> GetAllProducts() {
        return  productRepo.findAll();
    }

}

package com.example.ProductMangemnet.repository;


import com.example.ProductMangemnet.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
    boolean existsByTitle(String productName);
}

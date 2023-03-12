package com.example.ProductMangemnet.repository;

import com.example.ProductMangemnet.entity.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<product,Integer> {
}

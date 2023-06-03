package com.example.ProductMangemnet.repository;


import com.example.ProductMangemnet.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
    boolean existsByTitle(String productName);

    @Query("SELECT p.category, count (p) AS count FROM Product p GROUP BY p.category")
    List<Object[]> countProductsByCategory();
}

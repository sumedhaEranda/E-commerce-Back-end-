package com.example.ProductMangemnet.repository;


import com.example.ProductMangemnet.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cartrepo extends JpaRepository<Cart,Integer> {
}

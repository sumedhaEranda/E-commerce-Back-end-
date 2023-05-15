package com.example.ProductMangemnet.repository;


import com.example.ProductMangemnet.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomRepo extends JpaRepository<Customer,Integer> {
     Customer findByEmailAndName(String name, String email);
}

package com.example.ProductMangemnet.repository;


import com.example.ProductMangemnet.dto.GetInvoiceResponce;
import com.example.ProductMangemnet.dto.OrderDTO;
import com.example.ProductMangemnet.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> {

    @Query("SELECT invoice.id,invoice.createOrderDate, c.name, c.contactNo, c.email, invoice.totalAmount " +
            "FROM Order invoice " +
            "INNER JOIN invoice.customer c")
    List<Object[]> getCustomersWithAddresses();
}



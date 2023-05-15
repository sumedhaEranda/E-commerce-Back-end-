package com.example.ProductMangemnet.service;


import com.example.ProductMangemnet.dto.OrderDTO;
import com.example.ProductMangemnet.dto.ResponseOrderDTO;
import com.example.ProductMangemnet.entity.Customer;
import com.example.ProductMangemnet.entity.Order;
import com.example.ProductMangemnet.repository.OrderRepo;
import com.example.ProductMangemnet.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Random;

@Service
@Transactional
public class OrderService {
    @Autowired
    private OrderRepo orderRepository;
    @Autowired
    private ProductRepo productRepository;



    public Order getOrderDetail(int orderId) {
            Optional<Order> order = orderRepository.findById(orderId);
        return order.isPresent() ? order.get() : null;
    }



    public Order saveOrder(Order order) {
    return orderRepository.save(order);
    }



}

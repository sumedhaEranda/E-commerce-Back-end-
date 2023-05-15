package com.example.ProductMangemnet.service;


import com.example.ProductMangemnet.entity.Cart;
import com.example.ProductMangemnet.repository.Cartrepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final Cartrepo cartrepo;

    public CartService(Cartrepo cartRepository) {
        this.cartrepo = cartRepository;
    }

    public List<Cart> findAll() {
        return cartrepo.findAll();
    }
}

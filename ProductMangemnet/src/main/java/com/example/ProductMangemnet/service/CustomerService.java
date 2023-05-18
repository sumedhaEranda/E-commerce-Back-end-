package com.example.ProductMangemnet.service;

import com.example.ProductMangemnet.entity.Customer;
import com.example.ProductMangemnet.repository.CustomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomRepo customRepo;
    public void isCustomerPresent(Customer customer) {
        Customer customer1=customRepo.findByEmailAndName(customer.getName(),customer.getEmail());

        if (customer1 != null) {
            customer.setId(customer1.getId());

        }else{
            customRepo.save(customer);

        }

    }

    public List<Customer> GetAllProducts() {
        return customRepo.findAll();
    }
}

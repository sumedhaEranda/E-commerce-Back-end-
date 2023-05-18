package com.example.ProductMangemnet.service;


import com.example.ProductMangemnet.dto.GetInvoiceResponce;
import com.example.ProductMangemnet.dto.OrderDTO;
import com.example.ProductMangemnet.entity.Order;
import com.example.ProductMangemnet.repository.OrderRepo;
import com.example.ProductMangemnet.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class OrderService {
    @Autowired
    private OrderRepo orderRepository;
    @Autowired
    private ProductRepo productRepository;

    @Autowired
   private EntityManager entityManager;

    public Order getOrderDetail(int orderId) {
            Optional<Order> order = orderRepository.findById(orderId);
        return order.isPresent() ? order.get() : null;
    }



    public Order saveOrder(Order order) {
    return orderRepository.save(order);
    }


    public List<GetInvoiceResponce> getCustomersWithAddresses() {
        List<Object[]> queryResult = orderRepository.getCustomersWithAddresses();

        List<GetInvoiceResponce> customersWithAddresses = new ArrayList<>();
        for (Object[] row : queryResult) {
            GetInvoiceResponce dto = new GetInvoiceResponce();
            dto.setId((Integer) row[0]);
            try{
                dto.setCreateOrderDate((Date)row[1]);
            }catch (Exception e){
                e.getMessage();
            }

            dto.setName((String) row[2]);
            dto.setContact_no((String) row[3]);
            dto.setEmail((String) row[4]);
            dto.setTotal_amount((float) row[5]);

            customersWithAddresses.add(dto);
        }

        return customersWithAddresses;
    }

}

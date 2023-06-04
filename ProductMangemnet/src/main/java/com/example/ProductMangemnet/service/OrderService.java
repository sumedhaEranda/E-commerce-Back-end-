package com.example.ProductMangemnet.service;


import com.example.ProductMangemnet.dto.*;
import com.example.ProductMangemnet.entity.Order;
import com.example.ProductMangemnet.repository.OrderRepo;
import com.example.ProductMangemnet.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.*;


@Service
@Transactional
public class OrderService {
    @Autowired
    private OrderRepo orderRepository;
    @Autowired
    private ProductRepo productRepository;

    @Autowired
   private EntityManager entityManager;

    public List<RespoceOrderDetails> getOrderDetail(int orderId) {
        List<Object[]> queryResult= orderRepository.getOrderId(orderId);
        List<RespoceOrderDetails> respoceOrderDetails = new ArrayList<>();
        for (Object[] row : queryResult) {
            RespoceOrderDetails dto = new RespoceOrderDetails();
            dto.setPid((Integer) row[0]);
            dto.setTitle((String) row[1]);
            dto.setCategory((String) row[2]);
            dto.setImgpath((String) row[3]);
            dto.setPrice((Float) row[4]);
            dto.setQuantity((Integer) row[5]);
            dto.setTotalamount((float) row[6]);
            respoceOrderDetails.add(dto);
        }
        return respoceOrderDetails;
    }





    public int saveOrder(Order order) {
        Order savedOrder = orderRepository.save(order);
        return savedOrder.getId();
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

    public List<GetSalesOrder> getAllSalesOrderforCategory() {
        List<Object[]> queryResult = orderRepository.getSalesOrderforCategory();

        List<GetSalesOrder> getSalesor = new ArrayList<>();
        GetSalesOrder salesOrderPizza = new GetSalesOrder();
        GetSalesOrder salesOrderBurger = new GetSalesOrder();
        GetSalesOrder salesOrderBread = new GetSalesOrder();

        List<Data> dataPizza = new ArrayList<>();
        List<Data> dataBurger = new ArrayList<>();
        List<Data> dataBread = new ArrayList<>();

        for (Object[] row : queryResult) {
            String category = (String) row[0];
            Integer quantity = (Integer) row[1];
            String title = (String) row[2];

            Data data = new Data();
            data.setX(title);
            data.setY(quantity);

            if (category.equals("Pizza")) {
                dataPizza.add(data);
            } else if (category.equals("Burger")) {
                dataBurger.add(data);
            }
            else if (category.equals("Bread")) {
                dataBread.add(data);
            }
        }

        salesOrderPizza.setId("pizza");
        salesOrderPizza.setData(dataPizza);
        getSalesor.add(salesOrderPizza);

        salesOrderBurger.setId("burger");
        salesOrderBurger.setData(dataBurger);
        getSalesor.add(salesOrderBurger);

        salesOrderBread.setId("Bread");
        salesOrderBread.setData(dataBread);
        getSalesor.add(salesOrderBread);

        return getSalesor;

    }

    public int deleteOrderByIdDetail(int orderId) {

        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isPresent()) {
            orderRepository.deleteById(orderId);
        } else {

        }
        return orderId;
    }

}

package com.example.ProductMangemnet.dto;


import com.example.ProductMangemnet.entity.Cart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.Temporal;
import java.util.Date;
import java.util.List;
@Service
@AllArgsConstructor
@Getter
@Setter
public class OrderDTO {


    private List<Cart> cartItems;
    private String email;
    private String name;
    private String contactNo;

    private String city;

    private String address;

    private float totalAmount;


    public OrderDTO() {
    }


}

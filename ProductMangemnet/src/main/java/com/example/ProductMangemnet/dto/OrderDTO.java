package com.example.ProductMangemnet.dto;


import com.example.ProductMangemnet.entity.Cart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
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

    public OrderDTO() {
    }


}

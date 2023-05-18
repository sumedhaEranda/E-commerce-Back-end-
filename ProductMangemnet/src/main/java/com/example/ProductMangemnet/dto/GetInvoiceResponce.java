package com.example.ProductMangemnet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class GetInvoiceResponce {


   private int id;
   private  String name;
   private  String contact_no;
   private String email;
   private float total_amount;
   private Date CreateOrderDate;
   public GetInvoiceResponce() {

   }
}

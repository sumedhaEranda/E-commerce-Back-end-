package com.example.ProductMangemnet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter

public class ResponseOrderDTO {

    private int invoiceNumber;

    private String OrderDescription;
    private long orderId;
}

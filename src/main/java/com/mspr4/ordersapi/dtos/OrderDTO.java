package com.mspr4.ordersapi.dtos;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class OrderDTO {
    private Long id;
    private Integer quantity;
    private BigDecimal unitPrice;
    private Long customerId;
}

package com.mspr4.ordersapi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor @AllArgsConstructor @Data @Builder @ToString
@Table(name = "orders")
    public class Order {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private Integer quantity;
        private BigDecimal unitPrice;
        private Long customerId;


}

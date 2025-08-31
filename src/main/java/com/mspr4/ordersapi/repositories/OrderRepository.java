package com.mspr4.ordersapi.repositories;

import com.mspr4.ordersapi.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
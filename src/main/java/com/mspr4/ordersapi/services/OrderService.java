package com.mspr4.ordersapi.services;

import com.mspr4.ordersapi.dtos.OrderDTO;
import com.mspr4.ordersapi.mappers.OrderMapperDTO;

import java.util.List;

    public interface OrderService {
        OrderDTO create(OrderDTO dto);
        OrderDTO update(Long id, OrderDTO dto);
        OrderDTO findById(Long id);
        List<OrderDTO> findAll();
        void delete(Long id);
    }


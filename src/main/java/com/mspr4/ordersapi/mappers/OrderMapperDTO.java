package com.mspr4.ordersapi.mappers;

import com.mspr4.ordersapi.dtos.OrderDTO;
import com.mspr4.ordersapi.entities.Order;

import org.springframework.stereotype.Service;

@Service
public class OrderMapperDTO {
    public OrderDTO toDto(Order entity) {
        if (entity == null) return null;
        OrderDTO dto = new OrderDTO();
        dto.setId(entity.getId());
        dto.setQuantity(entity.getQuantity());
        dto.setUnitPrice(entity.getUnitPrice());
        dto.setCustomerId(entity.getCustomerId());
        return dto;
    }


    public Order toEntity(OrderDTO dto) {
        if (dto == null) return null;
        Order entity = new Order();
        entity.setId(dto.getId());
        entity.setQuantity(dto.getQuantity());
        entity.setUnitPrice(dto.getUnitPrice());
        entity.setCustomerId(dto.getCustomerId());
        return entity;
    }
}

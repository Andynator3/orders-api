package com.mspr4.ordersapi.services.impl;

import com.mspr4.ordersapi.dtos.OrderDTO;
import com.mspr4.ordersapi.entities.Order;
import com.mspr4.ordersapi.exceptions.OrderNotFoundException;
import com.mspr4.ordersapi.mappers.OrderMapperDTO;
import com.mspr4.ordersapi.repositories.OrderRepository;
import com.mspr4.ordersapi.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

    @Service
    @Transactional
    @RequiredArgsConstructor
    public class OrderServiceImpl implements OrderService {
        private final OrderRepository orderRepository;
        private final OrderMapperDTO orderMapperDTO;


        @Override
        public OrderDTO create(OrderDTO dto) {
            Order entity = orderMapperDTO.toEntity(dto);
            Order saved = orderRepository.save(entity);
            return orderMapperDTO.toDto(saved);
        }

        @Override
        public OrderDTO findById(Long id) {
            return orderRepository.findById(id)
                    .map(orderMapperDTO::toDto)
                    .orElseThrow(() -> new OrderNotFoundException("Order not found with id " + id));
        }

        @Override
        public List<OrderDTO> findAll() {
            return orderRepository.findAll().stream().map(orderMapperDTO::toDto).collect(Collectors.toList());
        }

        @Override
        public OrderDTO update(Long id, OrderDTO dto) {
            return orderRepository.findById(id).map(order -> {
                order.setQuantity(dto.getQuantity());
                order.setUnitPrice(dto.getUnitPrice());
                order.setCustomerId(dto.getCustomerId());
                return orderMapperDTO.toDto(orderRepository.save(order));
            }).orElseThrow(() -> new OrderNotFoundException("Order not found with id " + id));
        }

        @Override
        public void delete(Long id) {
            if (!orderRepository.existsById(id)) {
                throw new OrderNotFoundException("Order not found with id " + id);
            }
            orderRepository.deleteById(id);
        }

    }

package com.mspr4.ordersapi.web;

import com.mspr4.ordersapi.dtos.OrderDTO;
import com.mspr4.ordersapi.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
    public class OrderRestController {
        private final OrderService orderService;

        @PostMapping
        public ResponseEntity<OrderDTO> create(@RequestBody OrderDTO dto) {
            return ResponseEntity.status(201).body(orderService.create(dto));
        }
        @GetMapping
        public ResponseEntity<List<OrderDTO>> list() {
            return ResponseEntity.ok(orderService.findAll());
        }

        @GetMapping("/{id}")
        public ResponseEntity<OrderDTO> getById(@PathVariable Long id) {
            return ResponseEntity.ok(orderService.findById(id));
        }

        @PutMapping("/{id}")
        public ResponseEntity<OrderDTO> update(@PathVariable Long id,  @RequestBody OrderDTO dto) {
            return ResponseEntity.ok(orderService.update(id, dto));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable Long id) {
            orderService.delete(id);
            return ResponseEntity.noContent().build();
        }

    }

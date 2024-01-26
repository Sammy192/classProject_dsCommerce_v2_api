package com.devsamuca.dscommercev2.services;

import com.devsamuca.dscommercev2.dto.OrderDTO;
import com.devsamuca.dscommercev2.entities.Order;
import com.devsamuca.dscommercev2.repositories.OrderRepository;
import com.devsamuca.dscommercev2.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new OrderDTO(order);
    }
}

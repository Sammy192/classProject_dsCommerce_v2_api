package com.devsamuca.dscommercev2.repositories;

import com.devsamuca.dscommercev2.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}

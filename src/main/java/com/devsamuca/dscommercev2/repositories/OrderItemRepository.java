package com.devsamuca.dscommercev2.repositories;

import com.devsamuca.dscommercev2.entities.OrderItem;
import com.devsamuca.dscommercev2.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}

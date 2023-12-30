package com.devsamuca.dscommercev1.repositories;

import com.devsamuca.dscommercev1.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}

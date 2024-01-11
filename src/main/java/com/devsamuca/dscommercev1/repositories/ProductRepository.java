package com.devsamuca.dscommercev1.repositories;

import com.devsamuca.dscommercev1.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    /* consulta usando jpql
    @Query("SELECT obj FROM Product obj " +
            "WHERE UPPER(obj.name) LIKE UPPER(CONCAT('%', :name, '%'))")
    Page<Product> searchByName(String name, Pageable pageable);*/

    //consulta usando jpa query methods
    Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);

}

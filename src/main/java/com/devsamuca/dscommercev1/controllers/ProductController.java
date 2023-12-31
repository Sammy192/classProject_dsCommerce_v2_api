package com.devsamuca.dscommercev1.controllers;


import com.devsamuca.dscommercev1.dto.ProductDTO;
import com.devsamuca.dscommercev1.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
       ProductDTO dto  = service.findById(id);
       return ResponseEntity.ok(dto);
    }

    /* Duas maneiras de retornar o status:
        *  usando a notation ResponseStatus
        *  usando o RespnseEntity no método */

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<ProductDTO> findAll(Pageable pageable) {
        Page<ProductDTO> dto = service.findAll(pageable);
        return dto;
    }

    @PostMapping
    public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

}

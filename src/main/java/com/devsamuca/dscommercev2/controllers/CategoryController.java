package com.devsamuca.dscommercev2.controllers;


import com.devsamuca.dscommercev2.dto.CategoryDTO;
import com.devsamuca.dscommercev2.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    /* Duas maneiras de retornar o status:
     *  usando a notation ResponseStatus
     *  usando o RespnseEntity no método */

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryDTO> findAll() {
        List<CategoryDTO> dto = service.findAll();
        return dto;
    }

/*  @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll() {
        List<CategoryDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }*/
}

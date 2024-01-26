package com.devsamuca.dscommercev2.services;

import com.devsamuca.dscommercev2.dto.CategoryDTO;
import com.devsamuca.dscommercev2.entities.Category;
import com.devsamuca.dscommercev2.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        List<Category> result = repository.findAll();
        return result.stream().map(x -> new CategoryDTO(x)).toList();
    }

}

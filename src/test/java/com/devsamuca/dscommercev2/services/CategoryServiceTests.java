package com.devsamuca.dscommercev2.services;

import com.devsamuca.dscommercev2.dto.CategoryDTO;
import com.devsamuca.dscommercev2.entities.Category;
import com.devsamuca.dscommercev2.repositories.CategoryRepository;
import com.devsamuca.dscommercev2.tests.CategoryFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class CategoryServiceTests {

    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    private Category category;
    private List<Category> list;

    @BeforeEach
    void setUp() throws Exception {
        category = CategoryFactory.createCategory();

        list = new ArrayList<>();
        list.add(category);

        Mockito.when(categoryRepository.findAll()).thenReturn(list);

    }

    @Test
    public void findAllShouldReturnListCategoryDTO() {
        List<CategoryDTO> result = categoryService.findAll();

        Assertions.assertEquals(result.size(), 1);
        Assertions.assertEquals(result.get(0).getId(), category.getId());
        Assertions.assertEquals(result.get(0).getName(), category.getName());
    }
}

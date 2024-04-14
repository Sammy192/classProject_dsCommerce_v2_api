package com.devsamuca.dscommercev2.tests;

import com.devsamuca.dscommercev2.entities.Category;

public class CategoryFactory {

    public static Category createCategory() {
        return new Category(1L, "Games");
    }

    public static Category createCategory(Long id, String name) {
        return  new Category(id, name);
    }
}

package com.project.ecommerce.Service;

import com.project.ecommerce.entities.Category;
import com.project.ecommerce.entities.Product;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAllCategories();
    Optional<Category> getCategoryById(Long categoryId);
    Category createCategory(Category category);
    Category updateCategory(Long categoryId , Category category);
    void deleteCategory(Long categoryId);
}

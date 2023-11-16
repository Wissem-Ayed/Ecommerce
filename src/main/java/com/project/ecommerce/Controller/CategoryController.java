package com.project.ecommerce.Controller;


import com.project.ecommerce.Service.CategoryService;
import com.project.ecommerce.entities.Category;
import com.project.ecommerce.entities.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    public final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>>getAllCategories(){
        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);

    }
    @GetMapping("/{categoryId}")
    public ResponseEntity<Category>getCategoryById(@PathVariable Long categoryId){
        Optional<Category> categoryOptional = categoryService.getCategoryById(categoryId);
        return categoryOptional.map(category -> new ResponseEntity<>(category,HttpStatus.OK)).
                orElseGet(() -> new ResponseEntity<> (HttpStatus.NOT_FOUND) );
    }

    @PostMapping
    public ResponseEntity<Category>createCategory(@RequestBody Category category){
        Category savedCategory = categoryService.createCategory(category);
        return new ResponseEntity<>(savedCategory,HttpStatus.CREATED);
    }
    @PutMapping("/{categoryId}")
    public ResponseEntity<Category> upadateCategory(@PathVariable Long categoryId,@RequestBody  Category category){
        Category updatedCategory = categoryService.updateCategory(categoryId,category);
        return new ResponseEntity<>(updatedCategory,HttpStatus.OK);
    }
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long categoryId){
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

package com.project.ecommerce.Service;

import com.project.ecommerce.Exceptions.NotFoundException;
import com.project.ecommerce.dao.CategoryRepository;
import com.project.ecommerce.dao.ProductRepository;
import com.project.ecommerce.entities.Category;
import com.project.ecommerce.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{


    private final CategoryRepository categoryRepository ;

    private final ProductRepository productRepository;



    public ProductServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long productId) {

        return productRepository.findById(productId);
    }

    @Override
    public Product createProduct(Product product) {
        Long categoryId =product.getCategory().getId();
        Category existingCategory = categoryRepository.findById(categoryId).get();
        product.setCategory(existingCategory);
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        if(!productRepository.existsById(productId)){
            throw new NotFoundException("Product not found");
        }
        product.setId(productId);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        if(!productRepository.existsById(productId)){
            throw new NotFoundException("Product Not found");
        }
         productRepository.deleteById(productId);
        }

    }


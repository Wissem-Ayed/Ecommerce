package com.project.ecommerce.Service;

import com.project.ecommerce.entities.Product;


import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();
    Optional<Product> getProductById(Long productId);
    Product createProduct(Product product);
    Product updateProduct(Long productId , Product product);
    void deleteProduct(Long productId);

}

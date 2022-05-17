package com.example.demo.Service;

import com.example.demo.Entity.Product;
import com.example.demo.Entity.User;

import org.springframework.stereotype.Component;

public interface ProductService {

    public Product saveProduct(Product product);

    public Product findByProductId(Long id);
    public Product findByProjectId(Long id);
}

package com.example.demo.Service;

import com.example.demo.Entity.Product;
import com.example.demo.Entity.User;

import org.springframework.stereotype.Component;

import java.util.List;

public interface ProductService {

    public Product saveProduct(Product product);

    public Product findByProductId(Integer id);
    public Product findByProjectId(Long id);
    List<Product> findAllProduct();
}

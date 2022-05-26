package com.example.demo.Service;

import com.example.demo.Entity.Product;
import com.example.demo.Entity.User;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductService {

    public Product saveProduct(Product product);

    public Product findByProductId(Integer id);
    public Product findByProjectId(Long id);
    List<Product> findAllProduct();
}

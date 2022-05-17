package com.example.demo.Service.ServiceImpl;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.Entity.Product;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Entity.Project;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;

@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        product = productRepository.save(product);
        return product;    }

    @Override
    public Product findByProductId(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        return product;    }

    @Override
    public Product findByProjectId(Long id) {
        return null;
    }
}

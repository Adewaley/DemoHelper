package com.example.demo.Service;

import com.example.demo.Entity.Category;
import com.example.demo.Entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    private List<Product> productList;

    @BeforeEach
    public void setup() {
        Date time = new Date();
        productList = new ArrayList<>();
        productList.add(new Product());
        productList.add(new Product());
        productList.get(0).setTimeCreated(time);
        productList.get(1).setTimeCreated(time);
    }

    @Test
    public void saveTest() {
        productService.saveProduct(productList.get(0));
        productService.saveProduct(productList.get(1));
    }

    @Test
    public void findAllTest() {
        productList.clear();
        productList = productService.findAllProduct();
    }

    @Test
    public void findOneByIdTest() {
        productList.clear();
        productList = productService.findAllProduct();
        Product test1 = productList.get(0);
        //Product testget = productService.findByProductId(test1.getProductId());
    }

}

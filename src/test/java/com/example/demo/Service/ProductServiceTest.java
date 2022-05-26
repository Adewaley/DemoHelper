package com.example.demo.Service;

import com.example.demo.Entity.Category;
import com.example.demo.Entity.Product;
import com.example.demo.Entity.Project;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@SpringBootTest
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
        Product test1_ = new Product();
        Product test1 = productService.saveProduct(test1_);
        Product test2 = productService.saveProduct(productList.get(1));

        Assert.assertEquals(test1, test1_);

    }

    @Test
    public void findAllTest() {
        productList.clear();
        productList = productService.findAllProduct();
        Assert.assertTrue(productList != null);
    }

    @Test
    public void findOneByIdTest() {
        productList.clear();
        productList = productService.findAllProduct();
        Product test1 = productList.get(0);
        //Product testget = productService.findByProductId(test1.getProductId());
        Assert.assertEquals(test1, productList.get(0));
    }

}

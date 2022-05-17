package com.example.demo.Controller;

import com.example.demo.Entity.Product;
import com.example.demo.Entity.User;
import com.example.demo.Service.ProductService;
import com.example.demo.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
    @ResponseBody
    public Product saveProduct(@RequestBody Product product) {
        Product productResponse = productService.saveProduct(product);
        return productResponse;
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    @ResponseBody
    public Product getProductDetails(@PathVariable Long productId) {
        Product productResponse = productService.findByProductId(productId);

        return productResponse;
    }
}

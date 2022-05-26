package com.example.demo.Controller;

import com.example.demo.Entity.Category;
import com.example.demo.Entity.Product;
import com.example.demo.Entity.User;
import com.example.demo.Service.CategoryService;
import com.example.demo.Service.ProductService;
import com.example.demo.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ProductController")
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    public List<Product> getAllProduct() {
        return productService.findAllProduct();
    }

    @GetMapping
    public Product getProductId(@RequestParam("id") Integer id) {
        if (id == null) {
            return null;
        }
        return productService.findByProductId(id);
    }

    @PostMapping("/saveAProduct")
    public Product createProduct(@RequestParam("description") String description,
                       @RequestParam("type") String type,
                       @RequestParam("detail") String detail,
                       @RequestParam("tech_specs") String techSpecs) {
        Product product = new Product();
        product.setDescription(description);
        product.setType(detail);
        product.setTechnicalSpecification(techSpecs);
        //product.setTimeCreated();
        return productService.saveProduct(product);
    }

    @PutMapping("/products/")
    public Product updateProduct(@RequestParam("description") String description,
                              @RequestParam("type") String type,
                              @RequestParam("detail") String detail,
                              @RequestParam("tech_specs") String techSpecs,
                              @RequestParam("id") Integer id) {
        Product product = productService.findByProductId(id);
        product.setDescription(description);
        product.setType(detail);
        product.setTechnicalSpecification(techSpecs);
        return productService.saveProduct(product);
    }
}


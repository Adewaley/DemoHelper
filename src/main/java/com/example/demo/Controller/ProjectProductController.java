package com.example.demo.Controller;

import com.example.demo.Entity.Category;
import com.example.demo.Entity.Product;
import com.example.demo.Entity.Project;
import com.example.demo.Entity.ProjectProduct;
import com.example.demo.Service.CategoryService;
import com.example.demo.Service.ProductService;
import com.example.demo.Service.ProjectProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/ProjectProductController")
public class ProjectProductController {
    @Autowired
    private ProjectProductService projectProductService;
    @Autowired
    private ProductService productService;

    @GetMapping("/allProjectProduct")
    public List<ProjectProduct> getAllProjectProduct() {
        return projectProductService.findAll();
    }

    @GetMapping("/getProjectProduct")
    public List<ProjectProduct> getProjectProductById(@RequestParam("id") Integer id) {
        if (id == null) {
            return null;
        }
        Product currentProduct = productService.findByProductId(id);
        return projectProductService.findOneProjectProductByProductId(currentProduct);
    }

    @PostMapping("/createProjectProduct")
    public ProjectProduct createProjectProduct( /**@RequestParam("time") Date time_added**/) {
        Date time_added = new Date();
        Project test = new Project();
        Product testp = new Product();
        if (time_added != null) {
            ProjectProduct projProd = new ProjectProduct();
            projProd.setTimeAdded(time_added);
            return projectProductService.saveProjectProduct(projProd, testp, test);
        } else {
            return null;
        }
    }
}

package com.example.demo.Controller;

import com.example.demo.Entity.Category;
import com.example.demo.Entity.ProjectProduct;
import com.example.demo.Service.CategoryService;
import com.example.demo.Service.ProjectProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/PrjectProductController")
public class ProjectProductController {
    @Autowired
    private ProjectProductService projectProductService;

    @GetMapping("/allProjectProduct")
    public List<ProjectProduct> getAllProjectProduct() {
        return projectProductService.findAll();
    }

    @GetMapping
    public ProjectProduct getProjectProductById(@RequestParam("id") Integer id) {
        if (id == null) {
            return null;
        }
        return projectProductService.findOneProjectProductByProductId(id);
    }

    @PostMapping
    public ProjectProduct createProjectProduct(@RequestParam("time") Date time_added) {
        //Date time_added = new Date();
        if (time_added != null) {
            ProjectProduct projProd = new ProjectProduct();
            projProd.setTimeAdded(time_added);
            return projectProductService.saveProjectProduct(projProd);
        } else {
            return null;
        }
    }
}

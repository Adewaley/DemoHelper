package com.example.demo.Controller;

import com.example.demo.Entity.Category;
import com.example.demo.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAllCategory() {
        return categoryService.findAll();
    }

    @GetMapping
    public Category getCategoryById(@RequestParam("id") Integer id) {
        if (id == null) {
            return null;
        }
        return categoryService.findOneById(id);
    }

    @PostMapping
    public Category createCategory(@RequestParam("name") String name) {
        if (name != null) {
            Category newCategory = new Category();
            newCategory.setName(name);
            return categoryService.save(newCategory);
        } else {
            return null;
        }
    }
}

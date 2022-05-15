package com.example.demo.Controller;

import com.example.demo.Entity.Category;
import com.example.demo.Entity.SubCategory;
import com.example.demo.Service.CategoryService;
import com.example.demo.Service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/SubCategory")
public class SubCategoryController {

    @Autowired
    private SubCategoryService subCategoryService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public SubCategory getSubCategoryById(@RequestParam("id") Integer id) {
        if (id == null) {
            return null;
        }
        return subCategoryService.findOneById(id);
    }

    @PostMapping
    public SubCategory createNewSubCategory(@RequestParam("categoryid") Integer categoryId,
                                            @RequestParam("name") String name,
                                            @RequestParam("template") String template) {
        if (categoryId == null || name == null || template == null) {
            return null;
        }
        Category category = categoryService.findOneById(categoryId);
        SubCategory newSubCategory = new SubCategory();
        newSubCategory.setName(name);
        newSubCategory.setTechnicalSpecificationTemplate(template);
        newSubCategory.setCategory(category);
        return subCategoryService.save(newSubCategory);
    }

    @GetMapping("/all")
    public List<SubCategory> getSubCategoryByCategory(@RequestParam("categoryid") Integer categoryId) {
        if (categoryId == null) {
            return null;
        }
        Category category = categoryService.findOneById(categoryId);
        return subCategoryService.findByCategory(category);
    }
}

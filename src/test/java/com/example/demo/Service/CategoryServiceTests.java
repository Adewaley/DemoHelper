package com.example.demo.Service;

import com.example.demo.Entity.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceTests {

    @Autowired
    private CategoryService categoryService;

    private List<Category> categoryList;

    @BeforeEach
    public void setup() {
        categoryList = new ArrayList<>();
        categoryList.add(new Category());
        categoryList.add(new Category());
        categoryList.get(0).setName("categoryTest1");
        categoryList.get(1).setName("categoryTest2");
    }

    @Test
    public void saveTest() {
        categoryService.save(categoryList.get(0));
        categoryService.save(categoryList.get(1));
    }

    @Test
    public void findAllTest() {
        categoryList.clear();
        categoryList = categoryService.findAll();
    }

    @Test
    public void findOneByIdTest() {
        categoryList.clear();
        categoryList = categoryService.findAll();
        Category test1 = categoryList.get(0);
        Category testget = categoryService.findOneById(test1.getId());
    }
}

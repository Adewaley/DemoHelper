package com.example.demo.Service;

import com.example.demo.Entity.Category;
import com.example.demo.Entity.SubCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SubCategoryServiceTests {
    @Autowired
    SubCategoryService subCategoryService;

    @Autowired
    CategoryService categoryService;

    Category category;
    SubCategory subCategory;

    @BeforeEach
    public void setup() {
        Category newCategory = new Category();
        category.setName("subCategoryTest1");
        category = categoryService.save(category);
        subCategory = new SubCategory();
        subCategory.setCategory(category);
        subCategory.setTechnicalSpecificationTemplate("subCategoryTestTemplate1");
        subCategoryService.save(subCategory);
    }

    @Test
    public void saveTest() {
        Category newCategory = new Category();
        category.setName("subCategoryTest2");
        Category savedCategory = categoryService.save(newCategory);
        SubCategory subCategory1 = new SubCategory();
        subCategory1.setCategory(savedCategory);
        subCategory1.setTechnicalSpecificationTemplate("subCategoryTestTemplate2");
        SubCategory savedSubcategory = subCategoryService.save(subCategory1);
        Assertions.assertEquals(savedCategory.getName(), subCategory1.getName());
    }

    @Test
    public void findOneByIdTest() {
        SubCategory finded = subCategoryService.findOneById(subCategory.getId());
        Assertions.assertEquals(finded.getName(), subCategory.getName());
    }

    @Test
    public void findByCategoryTest() {
        List<SubCategory> subCategoryList = subCategoryService.findByCategory(category);
        Assertions.assertEquals(subCategoryList.get(0).getName(), subCategory.getName());
    }
}

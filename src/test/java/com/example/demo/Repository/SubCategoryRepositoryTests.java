package com.example.demo.Repository;

import com.example.demo.Entity.Category;
import com.example.demo.Entity.SubCategory;
import com.example.demo.Service.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SubCategoryRepositoryTests {
    @Autowired
    SubCategoryRepository subCategoryRepository;
    @Autowired
    CategoryService categoryService;

    private Category mainCategory;
    private List<SubCategory> subCategoryList1;

    @BeforeEach
    public void setup() {
        mainCategory = new Category();
        mainCategory.setName("subCategory");
        categoryService.save(mainCategory);
        SubCategory sub1 = new SubCategory();
        sub1.setCategory(mainCategory);
        sub1.setName("sub1");
        sub1.setTechnicalSpecificationTemplate("sub1Template");

        subCategoryList1 = new ArrayList<>();
        subCategoryList1.add(sub1);
        subCategoryRepository.save(sub1);
    }

    @Test
    public void getAllSubCategoryByCategory () {
        List<SubCategory> subCategoryList2 = subCategoryRepository.findByCategory(mainCategory);
        Assertions.assertEquals(subCategoryList1.get(0).getId(), subCategoryList2.get(1).getId());
    }
}

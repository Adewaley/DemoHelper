package com.example.demo.Service;

import com.example.demo.Entity.Category;
import com.example.demo.Entity.SubCategory;

import java.util.List;

public interface SubCategoryService {
    List<SubCategory> findByCategory(Category category);

    SubCategory findOneById(int id);

    SubCategory save(SubCategory subCategory);
}

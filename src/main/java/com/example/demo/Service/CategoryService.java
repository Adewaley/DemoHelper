package com.example.demo.Service;

import com.example.demo.Entity.Category;

import java.util.List;

public interface CategoryService {


    List<Category> findAll();

    Category findOneById(int id);

    Category save(Category category);

    interface ProjectProductService {
    }
}

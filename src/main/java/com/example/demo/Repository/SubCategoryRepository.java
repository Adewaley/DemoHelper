package com.example.demo.Repository;

import com.example.demo.Entity.Category;
import com.example.demo.Entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {
    List<SubCategory> findByCategory(Category category);
}

package com.example.demo.Service.ServiceImpl;

import com.example.demo.Entity.Category;
import com.example.demo.Entity.SubCategory;
import com.example.demo.Repository.SubCategoryRepository;
import com.example.demo.Service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryImpl implements SubCategoryService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Override
    public List<SubCategory> findByCategory(Category category) {
        return subCategoryRepository.findByCategory(category);
    }

    @Override
    public SubCategory findOneById(int id) {
        return subCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public SubCategory save(SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }
}

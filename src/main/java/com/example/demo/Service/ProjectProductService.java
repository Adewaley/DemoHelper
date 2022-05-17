package com.example.demo.Service;

import com.example.demo.Entity.Category;
import com.example.demo.Entity.ProjectProduct;
import com.example.demo.Repository.ProjectProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectProductService{
    List<ProjectProduct> findAll();

    ProjectProduct findOneProjectProductByProductId(Integer id);

    ProjectProduct saveProjectProduct(ProjectProduct projectProduct);
}

package com.example.demo.Service.ServiceImpl;

import com.example.demo.Entity.Category;
import com.example.demo.Entity.ProjectProduct;
import com.example.demo.Repository.ProjectProductRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.ProjectProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectProductServiceImpl implements ProjectProductService {

    @Autowired
    private ProjectProductRepository projectProductRepository;

    @Override
    public List<ProjectProduct> findAll() {
        return projectProductRepository.findAll();
    }

    @Override
    public ProjectProduct findOneProjectProductByProductId(Integer id) {
        return (ProjectProduct) projectProductRepository.findByProductId(id);
    }// can also find by projectId

    @Override
    public ProjectProduct saveProjectProduct(ProjectProduct projectProduct) {
        return projectProductRepository.save(projectProduct);
    }
}

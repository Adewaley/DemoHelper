package com.example.demo.Service.ServiceImpl;

import com.example.demo.Entity.Category;
import com.example.demo.Entity.Product;
import com.example.demo.Entity.Project;
import com.example.demo.Entity.ProjectProduct;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Repository.ProjectProductRepository;
import com.example.demo.Repository.ProjectRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.ProjectProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("projectProductServiceImpl")
public class ProjectProductServiceImpl implements ProjectProductService {

    @Autowired
    private ProjectProductRepository projectProductRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProjectProduct> findAll() {
        return projectProductRepository.findAll();
    }

//    @Override
//    public ProjectProduct findOneProjectProductByProductId(Integer id) {
//        return null;
//    }

    @Override
    public List<ProjectProduct> findOneProjectProductByProductId(Product product) {
        return  projectProductRepository.findByProduct(product);//orElse(null);
    }// can also find by projectId

    @Override
    public ProjectProduct saveProjectProduct(ProjectProduct projectProduct, Product product, Project project) {

        // getting product and project Id
//        projectRepository.findById(project.getProjectId());
//        productRepository.findById(product.getProductId());

        // save project and product
        Date currentDate = new Date();
        projectRepository.save(project);
        productRepository.save(product);

        projectProduct.setProduct(product);
        projectProduct.setProject(project);
        return projectProductRepository.save(projectProduct);

    }

    @Override
    public ProjectProduct findById(Integer Id) {
        return projectProductRepository.findById(Id).orElse(null);
    }
}

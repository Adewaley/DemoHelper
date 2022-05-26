package com.example.demo.Repository;

import com.example.demo.Entity.Product;
import com.example.demo.Entity.Project;
import com.example.demo.Entity.ProjectProduct;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectProductRepository extends JpaRepository<ProjectProduct, Integer> {
    List<ProjectProduct> findByProject(Project project);
    List<ProjectProduct> findByProduct(Product product);
}

package com.example.demo.Repository;

import com.example.demo.Entity.ProjectProduct;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ProjectProductRepository extends JpaRepository<ProjectProduct, Long> {
    List<ProjectProduct> findByProjectId(Long projectId);
    List<ProjectProduct> findByProductId(Long ProductId);
}

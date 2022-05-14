package com.example.demo.Repository;
import com.example.demo.Entity.Product;
import com.example.demo.Entity.Project;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ProjectRepository extends CrudRepository<Project, Serializable> {
    public List<Project> findByProjectId(int projectId);
}

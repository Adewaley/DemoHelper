package com.example.demo.Repository;
import com.example.demo.Entity.Product;
import com.example.demo.Entity.Project;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    public List<Project> findByProjectId(Integer projectId);
}

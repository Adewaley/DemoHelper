package com.example.demo.Service;

import com.example.demo.Entity.Project;
import com.example.demo.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {
    List<Project> findAllProject();

    Project findOneProjectById(Integer id);

    Project saveProject(Project category);

    public void createOneProject();

    public boolean deleteProject(Integer projectId);

}

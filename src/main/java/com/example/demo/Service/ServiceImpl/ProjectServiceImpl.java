package com.example.demo.Service.ServiceImpl;

import com.example.demo.Entity.Project;
import com.example.demo.Entity.User;
import com.example.demo.Repository.ProjectRepository;
import com.example.demo.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> findAllProject() {
        return projectRepository.findAll();
    }

    @Override
    public Project findOneProjectById(Integer id) {
        return (Project) projectRepository.findByProjectId(id);
    }

    @Override
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void createOneProject() {
        Date currentTime = new Date();
        Project project1 = new Project();
        project1.setTimeCreated(currentTime);
        project1.setTimeUpdated(currentTime);
        projectRepository.save(project1);
    }

    @Override
    public boolean deleteProject(Integer projectId) {
        Project toBeDeleted = findOneProjectById(projectId);
        if(toBeDeleted == null) return false;
        else{
            try{
                projectRepository.delete(toBeDeleted);
            }catch (Exception e){
                System.out.println("" + e.getMessage());
                e.printStackTrace();
                return false;
            }
            return true;
        }

    }
}

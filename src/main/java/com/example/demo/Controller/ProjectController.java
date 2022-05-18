package com.example.demo.Controller;

import com.example.demo.Entity.Project;

import com.example.demo.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/ProjectController")
public class ProjectController {
    //@Autowired
    private ProjectService projectService;

    @GetMapping("/allProject")
    public List<Project> getAllProjects() {
        return projectService.findAllProject();
    }

    @PostMapping("/ProjectController")
    public Project create(@RequestParam("time_created") Date dateCreated) {
        Project project = new Project();
        project.setTimeCreated(dateCreated);
        return projectService.saveProject(project);
    }

    @GetMapping
    public Project findById(@RequestParam("id") Integer id) {
        return projectService.findOneProjectById(id);
    }

    @PutMapping
    public Project update(@RequestParam("id") Integer id,
            @RequestParam("time_created") Date dateUpdated) {
        Project project = projectService.findOneProjectById(id);
        project.setTimeCreated(dateUpdated);
        return projectService.saveProject(project);
    }

    @PostMapping("/project/one")
    public void createProject() {
        projectService.createOneProject();
    }

    @PostMapping
    public void deleteProject(@RequestParam("id") Integer id) {
        projectService.deleteProject(id);
    }
}

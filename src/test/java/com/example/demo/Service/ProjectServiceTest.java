package com.example.demo.Service;

import com.example.demo.Entity.Category;
import com.example.demo.Service.ProjectService;
import com.example.demo.Entity.Project;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectServiceTest {
    //...

    @Autowired
    ProjectService projectService;

    private List<Project> projectList;

    @BeforeEach
    public void setup() {
        Date currentDate = new Date();
        projectList = new ArrayList<>();
        projectList.add(new Project());
        projectList.add(new Project());

        projectList.get(0).setTimeCreated(currentDate);
        projectList.get(1).setTimeCreated(currentDate);
    }

    @Test
    public void saveTest() {
//        System.out.println("project list: " + projectList.toString());
//        projectService.saveProject(projectList.get(0));
//        projectService.saveProject(projectList.get(1));
//        Integer expectedId = projectList.get(0).getProjectId();
//
//        Project expected = projectService.findOneProjectById(expectedId);
//        Assert.assertEquals(expected, projectList.get(0));

        Project expected = new Project();
        Project actual = projectService.saveProject(expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findAllTest() {
        //projectList.clear();
        List<Project> actual = projectService.findAllProject();
        Assert.assertTrue(actual != null);
    }

    @Test
    public void findOneByIdTest() {
        //projectList.clear();
        projectList = projectService.findAllProject();
        //System.out.println(projectList);
        Project test1 = projectList.get(0);
        Assert.assertTrue(test1 != null);
    }

    @Test
    public void createTest(){

        Integer actualCount = projectService.findAllProject().size();
        //System.out.println(actualCount);
        projectService.createOneProject();
        Integer expectedCount = projectService.findAllProject().size();
        //System.out.println(expectedCount);
        Assert.assertTrue(expectedCount > actualCount);
    }
}

package com.example.demo.Service;

import com.example.demo.Entity.Product;
import com.example.demo.Entity.Project;
import com.example.demo.Entity.ProjectProduct;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Test;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectProductServiceTest {

    @Autowired
    ProjectProductService projectProductService;

    @Autowired
    ProjectService projectService;

    @Autowired
    ProductService productService;

    private List<ProjectProduct> projectProductList;

    @BeforeEach
    public void setup() {
        Date currentDate = new Date();
        projectProductList = new ArrayList<>();
        projectProductList.add(new ProjectProduct());
        projectProductList.add(new ProjectProduct());

        projectProductList.get(0).setTimeAdded(currentDate);
        projectProductList.get(1).setTimeAdded(currentDate);
        //projectProductService.saveProjectProduct(projectProductList.get(0));
    }

    @Test
    public void saveTest() {
        Date currentTime = new Date();
        ProjectProduct expected = new ProjectProduct();
        expected.setTimeAdded(currentTime);

        Product testProduct = new Product();
        testProduct.setType("fan");

        Project testProject = new Project();
        testProject.setTimeCreated(currentTime);

        ProjectProduct actual = projectProductService.saveProjectProduct(expected, testProduct, testProject);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findAllTest() {
        //projectList.clear();
        List<ProjectProduct> actual = projectProductService.findAll();
        Assert.assertTrue(actual != null);
    }

    @Test
    public void findOneByIdTest() {

        projectProductList = projectProductService.findAll();
        Integer currentId = projectProductList.get(3).getProjectProductId();
        ProjectProduct currentProjProd = projectProductService.findById(currentId);

        System.out.println(currentProjProd);

        Assert.assertTrue(currentProjProd != null);
    }

    @Test
    public void findOneProjectProductByProductIdTest(){

        projectProductList = projectProductService.findAll();
        //Integer currId = projectProductList.get(0).getProduct().getProductId();
        //Integer test1 = projectProductService.findOneProjectProductByProductId(currId).getProductId();
        Product currentProd = projectProductList.get(0).getProduct();
        List<ProjectProduct> actual = projectProductService.findOneProjectProductByProductId(currentProd);
        Assert.assertTrue(actual != null);
    }
}

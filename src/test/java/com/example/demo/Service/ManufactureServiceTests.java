package com.example.demo.Service;

import com.example.demo.Entity.Manufacture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ManufactureServiceTests {
    @Autowired
    private ManufactureService manufactureService;

    private Manufacture manufacture;

    @BeforeEach
    public void setup() {
        Manufacture manufacture1 = new Manufacture();
        manufacture1.setWeb("manufactureTestWeb1");
        manufacture1.setPhone("manufactureTestPhone1");
        manufacture1.setDepartment("manufactureTestDepartment1");
        manufacture1.setEmail("manufactureTestEmail1");
        manufacture = manufactureService.save(manufacture1);
    }

    @Test
    public void saveTest() {
        Manufacture manufacture2 = new Manufacture();
        manufacture2.setWeb("manufactureTestWeb2");
        manufacture2.setPhone("manufactureTestPhone2");
        manufacture2.setDepartment("manufactureTestDepartment2");
        manufacture2.setEmail("manufactureTestEmail2");
        Manufacture savedManu = manufactureService.save(manufacture2);
        Assertions.assertEquals(savedManu.getDepartment(), manufacture2.getDepartment());
    }

    @Test
    public void findOneByIdTest() {
        Manufacture gettedManu = manufactureService.findOneById(manufacture.getId());
        Assertions.assertEquals(manufacture.getId(), gettedManu.getId());
    }
}

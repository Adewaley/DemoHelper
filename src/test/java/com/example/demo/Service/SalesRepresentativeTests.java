package com.example.demo.Service;

import com.example.demo.Entity.SalesRepresentative;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SalesRepresentativeTests {

    @Autowired
    private SalesRepresentativeService salesRepresentativeService;

    private SalesRepresentative salesRepresentative;

    @BeforeEach
    public void setUp() {
        SalesRepresentative sales1 = new SalesRepresentative();
        sales1.setName("Sales 1");
        sales1.setPhone("1234567890");
        sales1.setEmail("sales1@gmail.com");
        sales1.setWeb("sales1.com");
        salesRepresentative = salesRepresentativeService.saveSalesRep(sales1);
    }

    @Test
    public void saveSalesRepTest() {
        SalesRepresentative sales2 = new SalesRepresentative();
        sales2.setName("Sales 2");
        sales2.setPhone("0123456789");
        sales2.setEmail("sales2@gmail.com");
        sales2.setWeb("sales2.com");
        SalesRepresentative saveSalesRep = salesRepresentativeService.saveSalesRep(sales2);
        Assertions.assertEquals(saveSalesRep.getName(), sales2.getName());
    }

    @Test
    public void findBySalesRepIdTest() {
        SalesRepresentative getSalesRep = salesRepresentativeService.findBySalesRepId(salesRepresentative.getSalesRepresentativeId());
        Assertions.assertEquals(salesRepresentative.getSalesRepresentativeId(), getSalesRep.getSalesRepresentativeId());
    }
}

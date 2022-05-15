package com.example.demo.Controller;

import com.example.demo.Entity.Document;
import com.example.demo.Entity.SalesRepresentative;
import com.example.demo.Service.DocumentService;
import com.example.demo.Service.SalesRepresentativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/Sales_Rep")
public class SalesRepresentativeController {

    @Autowired
    private SalesRepresentativeService salesRepresentativeService;

    @RequestMapping(value = "/saveSalesRep", method = RequestMethod.POST)
    @ResponseBody
    public SalesRepresentative saveSalesRep(@RequestBody SalesRepresentative salesRepresentative) {
        SalesRepresentative salesRepResponse = salesRepresentativeService.saveSalesRep(salesRepresentative);
        return salesRepResponse;
    }
}

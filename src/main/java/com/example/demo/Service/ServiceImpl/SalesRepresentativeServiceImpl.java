package com.example.demo.Service.ServiceImpl;

import com.example.demo.Entity.Document;
import com.example.demo.Entity.SalesRepresentative;
import com.example.demo.Repository.DocumentRepository;
import com.example.demo.Repository.SalesRepresentativeRepository;
import com.example.demo.Service.SalesRepresentativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("salesRepresentativeServiceImpl")
public class SalesRepresentativeServiceImpl implements SalesRepresentativeService {

    @Autowired
    private SalesRepresentativeRepository salesRepresentativeRepository;

    @Override
    public SalesRepresentative saveSalesRep(SalesRepresentative salesRepresentative) {
        salesRepresentative = salesRepresentativeRepository.save(salesRepresentative);
        return salesRepresentative;
    }
}

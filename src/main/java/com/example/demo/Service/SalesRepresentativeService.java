package com.example.demo.Service;

import com.example.demo.Entity.SalesRepresentative;

public interface SalesRepresentativeService {

    public SalesRepresentative findBySalesRepId(int id);

    public SalesRepresentative saveSalesRep(SalesRepresentative salesRepresentative);
}

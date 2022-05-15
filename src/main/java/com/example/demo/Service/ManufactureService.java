package com.example.demo.Service;

import com.example.demo.Entity.Manufacture;

public interface ManufactureService {
    Manufacture findOneById(int id);

    Manufacture save(Manufacture manufacture);
}

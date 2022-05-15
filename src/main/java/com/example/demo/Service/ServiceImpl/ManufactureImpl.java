package com.example.demo.Service.ServiceImpl;

import com.example.demo.Entity.Manufacture;
import com.example.demo.Repository.ManufactureRepository;
import com.example.demo.Service.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManufactureImpl implements ManufactureService {

    @Autowired
    private ManufactureRepository manufactureRepository;

    @Override
    public Manufacture findOneById(int id) {
        return manufactureRepository.findById(id).orElse(null);
    }

    @Override
    public Manufacture save(Manufacture manufacture) {
        return manufactureRepository.save(manufacture);
    }
}

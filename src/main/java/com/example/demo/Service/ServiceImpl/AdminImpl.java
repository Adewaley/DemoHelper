package com.example.demo.Service.ServiceImpl;

import com.example.demo.Entity.Admin;
import com.example.demo.Repository.AdminRepository;
import com.example.demo.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin saveAdmin(Admin admin) {
        admin = adminRepository.save(admin);
        return admin;
    }

    @Override
    public Admin findByAdminId(int id) {
        Admin admin = adminRepository.findByAdminId(id);
        return admin;
    }

}

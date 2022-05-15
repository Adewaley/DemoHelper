package com.example.demo.Service;

import com.example.demo.Entity.Admin;
import org.springframework.stereotype.Component;

@Component
public interface AdminService {

    public Admin saveAdmin(Admin admin);

    public Admin findByAdminId(int id);
}

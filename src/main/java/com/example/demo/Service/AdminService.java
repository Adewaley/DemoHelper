package com.example.demo.Service;

import com.example.demo.Entity.Admin;

public interface AdminService {

    public Admin saveAdmin(Admin admin);

    public Admin findByAdminId(int id);
}

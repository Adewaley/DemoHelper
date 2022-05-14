package com.example.demo.Repository;

import com.example.demo.Entity.Admin;
import com.example.demo.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface AdminRepository extends CrudRepository<Admin, Serializable> {

    public Admin findByAdminId(int adminId);
}

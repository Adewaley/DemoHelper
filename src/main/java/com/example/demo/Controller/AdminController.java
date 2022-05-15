package com.example.demo.Controller;

import com.example.demo.Entity.Admin;
import com.example.demo.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/Admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/saveAdmin", method = RequestMethod.POST)
    @ResponseBody
    public Admin saveAdmin(@RequestBody Admin admin) {
        Admin adminResponse = adminService.saveAdmin(admin);
        return adminResponse;
    }

    @RequestMapping(value = "/{adminId}", method = RequestMethod.GET)
    @ResponseBody
    public Admin getAdminDetails(@PathVariable int adminId) {
        Admin adminResponse = adminService.findByAdminId(adminId);
        return adminResponse;
    }
}

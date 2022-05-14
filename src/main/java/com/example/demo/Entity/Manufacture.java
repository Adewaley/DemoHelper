package com.example.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "manufacture")
public class Manufacture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    private String department;
    private String phone;
    private String email;
    private String web;

    public Manufacture() {

    }

    public void setDepartment(String department) {
        this.department = department;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setWeb(String web) {
        this.web = web;
    }

    public int getId() {
        return id;
    }
    public String getDepartment() {
        return department;
    }
    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }
    public String getWeb() {
        return web;
    }
}
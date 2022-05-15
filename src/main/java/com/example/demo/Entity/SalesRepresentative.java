package com.example.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name="sales_representative")
public class SalesRepresentative {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int salesRepresentativeId;

    private String name;

    private String phone;

    private String email;

    private String web;

    public SalesRepresentative() {

    }

    public int getSalesRepresentativeId() {
        return salesRepresentativeId;
    }

    public void setSalesRepresentativeId(int salesRepresentativeId) {
        this.salesRepresentativeId = salesRepresentativeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
}

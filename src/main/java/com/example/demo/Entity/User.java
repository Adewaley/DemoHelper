package com.example.demo.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import javax.management.relation.Role;
import javax.persistence.*;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "UserProject_Id", referencedColumnName = "id")
    private List<Project> projectList = new ArrayList<>();


    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Column(name = "name", unique = true, nullable = false,length = 256)
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name =" password")
    private String password;

    @Column(name = "lastlogin")
    private Timestamp lastLogin;

    @Column(name = "creationtime")
    private Timestamp TimeOfCreation;

    public User(){
    }
    public User(String name){this.name = name;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Timestamp getTimeOfCreation() {
        return TimeOfCreation;
    }

    public void setTimeOfCreation(Timestamp timeOfCreation) {
        TimeOfCreation = timeOfCreation;
    }
}

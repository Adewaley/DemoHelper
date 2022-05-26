package com.example.demo.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import com.example.demo.Repository.ProjectProductRepository;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class ProjectProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_productid")
    private Integer projectProductId;

    //
    @ManyToOne(targetEntity = Project.class, cascade = CascadeType.DETACH)
    @JoinColumn (name="project_Id", nullable=false)
    private Project project;

    @ManyToOne(targetEntity = Product.class, cascade = CascadeType.DETACH)
    @JoinColumn (name="product_Id", nullable=false)
    private Product product;

    public Project getProject() {
        return this.project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Column(name = "time_Added")
    private Date timeAdded;

    public Integer getProjectProductId() {
        return projectProductId;
    }

    public void setProjectProductId(Integer id) {
        this.projectProductId = id;
    }

    public Date getTimeAdded() {
        return timeAdded;
    }

    public void setTimeAdded(Date timeAdded) {
        this.timeAdded = timeAdded;
    }
}

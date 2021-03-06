package com.example.demo.Entity;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class ProjectProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "projectProductid", nullable = false)
    private Long projectProductId;

    @Column(name = "projectId")
    private Long projectId;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    @Column(name = "productId")
    private Long productId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }



    @Column(name = "timeAdded")
    private Date timeAdded;

    public Long getProjectProductId() {
        return projectProductId;
    }

    public void setProjectProductId(Long id) {
        this.projectProductId = id;
    }

    public Date getTimeAdded() {
        return timeAdded;
    }

    public void setTimeAdded(Date timeAdded) {
        this.timeAdded = timeAdded;
    }
}

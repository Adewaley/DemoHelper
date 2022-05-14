package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "subcategory")
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @Column(name = "technical_specification_template")
    private String technicalSpecificationTemplate;

    @ManyToOne
    @JsonIgnore
    private Category category;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTechnicalSpecificationTemplate() {
        return technicalSpecificationTemplate;
    }

    public void setTechnicalSpecificationTemplate(String technicalSpecificationTemplate) {
        this.technicalSpecificationTemplate = technicalSpecificationTemplate;
    }
}
package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany
    @JsonIgnore
    private List<Product> productList;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
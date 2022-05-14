package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "category_id")
    private List<SubCategory> subCategoryList;

    public Category() {

    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.example.demo.Entity;

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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "productId", nullable = false)
    private Long productId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ProjectProduct_id", referencedColumnName = "productId")
    private List<ProjectProduct> projectProductList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "documentId", referencedColumnName = "productId")
    private List<Document> documentList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "Sales_Rep_id", referencedColumnName = "productId")
    private List<SalesRepresentative> salesRepresentativeList = new ArrayList<>();

    @Column(name = "subcategory")
    private String subCategory; // should be: private Category subCategory(once category entity has been created)

    @Column(name = "description")
    private String description;

    @Column(name =" type")
    private String type;

    @Column(name = "detail")
    private String detail;

    @Column(name = "technicalSpecification")
    private String technicalSpecification;

    @Column(name = "SalesRep")
    private String salesRep; // Should use embedded

    @Column(name = "manufacturer")
    private String manufacturer; // should use embedded

    @Column(name = "timeCreated")
    private Date timeCreated; // should use embedded

    @Column(name = "timeUpdated")
    private Date timUpdated; // should use embedded

    public Product(){
    }
    public Product(Long id){this.productId = id;}

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTechnicalSpecification() {
        return technicalSpecification;
    }

    public void setTechnicalSpecification(String technicalSpecification) {
        this.technicalSpecification = technicalSpecification;
    }

    public String getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(String salesRep) {
        this.salesRep = salesRep;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Date getTimUpdated() {
        return timUpdated;
    }

    public void setTimUpdated(Date timUpdated) {
        this.timUpdated = timUpdated;
    }
}

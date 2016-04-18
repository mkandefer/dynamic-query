package com.dynamicqueryproject.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import javax.persistence.CascadeType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "store")
@EqualsAndHashCode(exclude="categories", callSuper = true)
@ToString(exclude="categories", callSuper = true)
public class Store extends BaseEntity {

    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;

    @Column(name = "address")
    private String address;


    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    @OneToMany(targetEntity = ProductCategory.class, cascade = CascadeType.ALL, mappedBy = "store")
    private List<ProductCategory> categories = new ArrayList<>();

    public List<ProductCategory> getCategories() {
        return categories;
    }
    
    public void setCategories(List<ProductCategory> categories) {
        for (ProductCategory category : categories) {
            if (category.getStore() == null || !category.getStore().equals(this)) {
                category.setStore(this);
            }
        }
        this.categories = categories;

    }
    
}

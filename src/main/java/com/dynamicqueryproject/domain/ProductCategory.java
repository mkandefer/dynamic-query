package com.dynamicqueryproject.domain;



import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "product_category")
@EqualsAndHashCode(exclude={"store"}, callSuper = true)
@ToString(exclude={"store"}, callSuper = true)
public class ProductCategory extends BaseEntity {
    
    @Column(name="name")
    private String name;
    
    @Column(name="description")
    private String description;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="store_id", nullable = true)
    @JsonIgnore
    private Store store;
    
    
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
    
    public Store getStore() {
        return store;
    }
    
    public void setStore(Store store) {
        this.store = store;
        if(!store.getCategories().contains(this)) {
            store.getCategories().add(this);
        }
    }
     
    
}

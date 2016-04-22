package com.dynamicqueryproject.repo;

import com.dynamicqueryproject.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;


@RepositoryRestResource(collectionResourceRel = "productCategory", path = "productCategory")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long>, QueryDslPredicateExecutor<ProductCategory>, JpaSpecificationExecutor<ProductCategory> {    
    ProductCategory findById(@Param("id") Long id);
    List<ProductCategory> findByName(@Param("name") String name);
}
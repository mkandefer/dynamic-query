/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dynamicqueryproject.query.service;

import com.dynamicqueryproject.domain.ProductCategory;

/**
 *
 * @author mkandefer
 */
public interface ProductCategorySearchService {
 
    Iterable<ProductCategory> findBySearchTerm(String searchTerm);
    
    Iterable<ProductCategory> findAll();
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dynamicqueryproject.query.service.impl;

import com.dynamicqueryproject.domain.ProductCategory;
import com.dynamicqueryproject.query.ProductCategoryPredicates;
import com.dynamicqueryproject.query.service.ProductCategorySearchService;
import com.dynamicqueryproject.repo.ProductCategoryRepository;
import com.mysema.query.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mkandefer
 */

@Service
public class ProductCategorySearchServiceImpl implements ProductCategorySearchService {

    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public Iterable<ProductCategory> findBySearchTerm(String searchTerm) {
        Predicate searchPred = ProductCategoryPredicates.nameOrDescriptionContainsIgnoreCase(searchTerm);
        Iterable<ProductCategory> searchResults = repository.findAll(searchPred);
        return searchResults;
    }

    @Override
    public Iterable<ProductCategory> findAll() {
        return repository.findAll();
    }

}

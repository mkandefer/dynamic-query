/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dynamicqueryproject.query.service.impl;

import com.dynamicqueryproject.domain.Store;
import com.dynamicqueryproject.query.StorePredicates;
import com.dynamicqueryproject.query.service.StoreSearchService;
import com.dynamicqueryproject.repo.StoreRepository;
import com.mysema.query.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mkandefer
 */

@Service
public class StoreSearchServiceImpl implements StoreSearchService {

    @Autowired
    private StoreRepository repository;

    @Override
    public Iterable<Store> findBySearchTerm(String searchTerm) {
        Predicate searchPred = StorePredicates.nameOrDescriptionContainsIgnoreCase(searchTerm);
        Iterable<Store> searchResults = repository.findAll(searchPred);
        return searchResults;
    }

    @Override
    public Iterable<Store> findAll() {
        return repository.findAll();
    }

    @Override
    public Iterable<Store> findGreaterThan(int count) {
        Predicate countPred = StorePredicates.productsExceed(count);
        return repository.findAll(countPred);
    }

}

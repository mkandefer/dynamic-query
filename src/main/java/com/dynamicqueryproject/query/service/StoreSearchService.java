/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dynamicqueryproject.query.services;

import com.dynamicqueryproject.domain.Store;

/**
 *
 * @author mkandefer
 */
public interface StoreSearchService {
 
    Iterable<Store> findBySearchTerm(String searchTerm);
}
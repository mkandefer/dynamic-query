/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dynamicqueryproject.web.controller;

import com.dynamicqueryproject.domain.Store;
import com.dynamicqueryproject.query.services.StoreSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author mkandefer
 */

@BasePathAwareController
@ExposesResourceFor(Store.class)
public class StoreController {
    public static final String STORES_URI_PATH = "/store";
    
    @Autowired
    private StoreSearchService storeService;
    
    @RequestMapping(method = RequestMethod.GET, value = STORES_URI_PATH)
    @ResponseBody
    public Iterable<Store> search(@RequestParam(value = "search") String search) {
        if(search == null || search.equals("")) {
            return storeService.findAll();
        } else {
            return storeService.findBySearchTerm(search);
        }
    }
}
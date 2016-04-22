/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dynamicqueryproject.query;

import com.mysema.query.types.Predicate;
import com.dynamicqueryproject.domain.QStore;

/**
 *
 * @author mkandefer
 */
public final class StorePredicates {

    private StorePredicates() {
    }

    public static Predicate hasName(String name) {
        return QStore.store.name.eq(name);
    }

    public static Predicate nameOrDescriptionContainsIgnoreCase(String searchTerm) {
        if (searchTerm == null || searchTerm.isEmpty()) {
            return QStore.store.isNotNull();
        } else {
            return QStore.store.description.containsIgnoreCase(searchTerm)
                    .or(QStore.store.name.containsIgnoreCase(searchTerm));
        }
    }
    
     public static Predicate productsExceed(int count) {
         return QStore.store.categories.size().gt(count);
    }

}

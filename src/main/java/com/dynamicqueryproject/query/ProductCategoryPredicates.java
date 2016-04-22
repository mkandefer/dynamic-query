/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dynamicqueryproject.query;

import com.dynamicqueryproject.domain.QProductCategory;
import com.mysema.query.types.Predicate;

/**
 *
 * @author mkandefer
 */
public final class ProductCategoryPredicates {

    private ProductCategoryPredicates() {
    }

    public static Predicate hasName(String name) {
        return QProductCategory.productCategory.name.eq(name);
    }

    public static Predicate nameOrDescriptionContainsIgnoreCase(String searchTerm) {
        if (searchTerm == null || searchTerm.isEmpty()) {
            return QProductCategory.productCategory.isNotNull();
        } else {
            return QProductCategory.productCategory.description.containsIgnoreCase(searchTerm)
                    .or(QProductCategory.productCategory.name.containsIgnoreCase(searchTerm));
        }
    }

}

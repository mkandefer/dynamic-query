package com.dynamicqueryproject.domain.projections;

import com.dynamicqueryproject.domain.ProductCategory;
import com.dynamicqueryproject.domain.Store;
import java.util.List;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "inlineCategories", types = {Store.class})
public interface InlineCategories {

    Long getId();
    String getName();

    List<ProductCategory> getCategories();

}

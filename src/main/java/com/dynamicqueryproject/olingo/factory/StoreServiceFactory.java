/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dynamicqueryproject.olingo.factory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAContext;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAServiceFactory;
import org.apache.olingo.odata2.jpa.processor.api.exception.ODataJPARuntimeException;

/**
 *
 * @author mkandefer
 */
public class StoreServiceFactory extends ODataJPAServiceFactory {

    private static final String PERSISTENCE_UNIT_NAME = "default";

    @Override
    public ODataJPAContext initializeODataJPAContext()
            throws ODataJPARuntimeException {

        ODataJPAContext oDatJPAContext = this.getODataJPAContext();
        try {

            EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            oDatJPAContext.setEntityManagerFactory(emf);
            oDatJPAContext.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);

            return oDatJPAContext;

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

}

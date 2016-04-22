package com.dynamicqueryproject;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class OlingoWebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

     private static final Logger log = LogManager.getLogger();
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{RestConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/store.svc/*"};
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        
        try {
            super.onStartup(servletContext);
            servletContext.setInitParameter("javax.ws.rs.Application", "org.apache.olingo.odata2.core.rest.app.ODataApplication");
            servletContext.setInitParameter("org.apache.olingo.odata2.service.factory", "com.dynamicqueryproject.olingo.factory.StoreServiceFactory");
    
        } catch (Exception e) {
            log.error("Error configuring Olingo", e);
        }
    }
}

package com.dynamicqueryproject.repo;

import com.dynamicqueryproject.AppConfig;
import com.dynamicqueryproject.RestConfig;
import org.springframework.context.annotation.Import;

@Import(value = {AppConfig.class, RestConfig.class})
public class TestConfig {
    
}

package com.zy.springboot.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.QueryLookupStrategy;

@Configuration
@EnableJpaRepositories(
        basePackages= { "com.zy.springboot.jpa" },
        queryLookupStrategy = QueryLookupStrategy.Key.CREATE_IF_NOT_FOUND
)
public class OdmConf {

}

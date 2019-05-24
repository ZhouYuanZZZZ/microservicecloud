package com.zy.springboot.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages= { "com.zy.springboot.jpa" })
public class OdmConf {

}

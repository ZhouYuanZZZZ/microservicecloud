package com.zy.springcloud.microservicecloudfeign.conf;

import com.zy.microservicecloud.api.DataTransferServiceFallbackFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public DataTransferServiceFallbackFactory dataTransferServiceFallbackFactory(){

        return new DataTransferServiceFallbackFactory();
    }
}

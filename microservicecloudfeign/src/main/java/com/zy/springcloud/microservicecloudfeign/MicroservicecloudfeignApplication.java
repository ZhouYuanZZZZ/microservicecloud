package com.zy.springcloud.microservicecloudfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = {"com.zy.microservicecloud.api"})
@SpringBootApplication
public class MicroservicecloudfeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicecloudfeignApplication.class, args);
    }

}


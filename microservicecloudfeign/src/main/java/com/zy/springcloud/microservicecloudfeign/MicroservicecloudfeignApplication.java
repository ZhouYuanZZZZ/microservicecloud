package com.zy.springcloud.microservicecloudfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = {"com.zy.springcloud.microservicecloudfeign.api"})
@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
public class MicroservicecloudfeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicecloudfeignApplication.class, args);
    }

}


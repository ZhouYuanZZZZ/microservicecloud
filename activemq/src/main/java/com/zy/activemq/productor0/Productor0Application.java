package com.zy.activemq.productor0;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Productor0Application {

    public static void main(String[] args) {
        SpringApplication.run(Productor0Application.class, args);
    }

}


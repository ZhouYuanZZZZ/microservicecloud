package com.zy.activemq.productor0.conf;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConf {

    @Bean
    public ActiveMQQueue queue0(){
        ActiveMQQueue queue0 = new ActiveMQQueue("queue0");
        return queue0;
    }
}

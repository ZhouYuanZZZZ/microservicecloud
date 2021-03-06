package com.zy.activemq.consumer0.conf;

import com.zy.activemq.consumer0.services.MessageListener0;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import javax.annotation.Resource;
import javax.jms.Destination;

@Configuration
public class QueueConf {


    @Bean
    public ActiveMQQueue queue0(){
        ActiveMQQueue queue0 = new ActiveMQQueue("queue01?consumer.prefetchSize=1");

        return queue0;
    }


}

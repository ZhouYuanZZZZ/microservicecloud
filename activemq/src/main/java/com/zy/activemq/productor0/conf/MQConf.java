package com.zy.activemq.productor0.conf;



import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;
import org.apache.activemq.broker.region.policy.RedeliveryPolicyMap;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.DeliveryMode;
import javax.jms.Session;

@Configuration
public class MQConf implements EnvironmentAware {

    private Environment environment;

    @Bean
    public ActiveMQConnectionFactory targetConnectionFactory(ActiveMQQueue queue0,RedeliveryPolicy redeliveryPolicy){
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");
        RedeliveryPolicyMap redeliveryPolicyMap = activeMQConnectionFactory.getRedeliveryPolicyMap();
        redeliveryPolicyMap.put(queue0,redeliveryPolicy);

        return activeMQConnectionFactory;
    }

    @Bean
    public PooledConnectionFactory pooledConnectionFactory(ActiveMQConnectionFactory targetConnectionFactory){
        PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory();
        pooledConnectionFactory.setConnectionFactory(targetConnectionFactory);
        pooledConnectionFactory.setMaxConnections(10);
        return pooledConnectionFactory;
    }

    @Bean
    public SingleConnectionFactory connectionFactory(PooledConnectionFactory pooledConnectionFactory){
        SingleConnectionFactory singleConnectionFactory = new SingleConnectionFactory();
        singleConnectionFactory.setTargetConnectionFactory(pooledConnectionFactory);
        return singleConnectionFactory;
    }

    @Bean
    public RedeliveryPolicy redeliveryPolicy(){
        RedeliveryPolicy queuePolicy = new RedeliveryPolicy();
        queuePolicy.setInitialRedeliveryDelay(0);
        queuePolicy.setRedeliveryDelay(1000);
        queuePolicy.setUseExponentialBackOff(false);
        queuePolicy.setMaximumRedeliveries(3);
        return queuePolicy;
    }

    @Bean
    public JmsTemplate jmsTemplate(SingleConnectionFactory connectionFactory){
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(connectionFactory);
        jmsTemplate.setSessionTransacted(false);
        //开启发布订阅模式
       // jmsTemplate.setPubSubDomain(true);
        // deliveryMode, priority, timeToLive 的开关，要生效，必须配置explicitQosEnabled为true，默认false
        jmsTemplate.setExplicitQosEnabled(true);
        //发送模式  DeliveryMode.NON_PERSISTENT=1:非持久 ; DeliveryMode.PERSISTENT=2:持久
        jmsTemplate.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        //设置消息确认模式 需要客户端自行确认
        jmsTemplate.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);


       return jmsTemplate;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}

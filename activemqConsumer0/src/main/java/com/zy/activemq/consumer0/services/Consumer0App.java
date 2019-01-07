package com.zy.activemq.consumer0.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.jms.*;

@Service
public class Consumer0App  {

    private static final Logger logger = LoggerFactory.getLogger(Consumer0App.class);

    @Resource
    private Destination queue0;

    @Resource
    private SingleConnectionFactory connectionFactory;


    @PostConstruct
    public void test0() throws JMSException {
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        MessageConsumer consumer = session.createConsumer(queue0);

        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage)message;
                try {
                    String text = textMessage.getText();
                    logger.info(text);

                    throw new RuntimeException("xxx");
                    //message.acknowledge();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

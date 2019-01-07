package com.zy.activemq.productor0.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.jms.*;
import java.util.Date;
import java.util.UUID;

@Service
public class ProductorService {

    private static final Logger logger = LoggerFactory.getLogger(ProductorService.class);

    @Resource
    private SingleConnectionFactory connectionFactory;

    @Resource
    private Destination queue0;

    @Resource
    private MessageCreator0 messageCreator0;

    //@Scheduled(cron = "0/1 * * * * ? ")
    @PostConstruct
    public void test0() throws JMSException {
        Connection connection = connectionFactory.createConnection();

        //开启事务
        Session session = connection.createSession(true, Session.SESSION_TRANSACTED);

        MessageProducer producer = session.createProducer(queue0);

        String text = new Date().toString() + ":" + UUID.randomUUID().toString();
        TextMessage textMessage = session.createTextMessage(text);

        producer.send(textMessage);

        //提交事务
        session.commit();

        producer.close();
        session.close();
        connection.close();

        logger.info(text);

    }
}

package com.zy.activemq.productor0.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Service
public class ProductorService {

    private static final Logger logger = LoggerFactory.getLogger(ProductorService.class);

    @Resource
    private JmsTemplate jmsTemplate;

    @Resource
    private Destination queue0;

    @Resource
    private MessageCreator0 messageCreator0;

    @Scheduled(cron = "0/1 * * * * ? ")
    public void test0() {
        jmsTemplate.send(queue0, messageCreator0);
    }
}

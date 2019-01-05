package com.zy.activemq.productor0.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.Date;
import java.util.UUID;

@Service
public class MessageCreator0 implements MessageCreator {

    private Logger logger = LoggerFactory.getLogger(MessageCreator.class);

    @Override
    public Message createMessage(Session session) throws JMSException {
        String message = UUID.randomUUID().toString();
        message = new Date().toString()+":"+message;
        logger.info(message);
        return session.createTextMessage(message);
    }
}

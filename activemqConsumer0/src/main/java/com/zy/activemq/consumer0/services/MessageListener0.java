package com.zy.activemq.consumer0.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Service;

import javax.jms.*;

@Service
public class MessageListener0 implements SessionAwareMessageListener<TextMessage> {

    private Logger logger = LoggerFactory.getLogger(MessageListener0.class);

    @Override
    public void onMessage(TextMessage message, Session session) throws JMSException {
        try {
            String text = message.getText();
            logger.info(text);
            session.recover();
        } catch (JMSException e) {
            logger.error("",e);
        }
    }
}

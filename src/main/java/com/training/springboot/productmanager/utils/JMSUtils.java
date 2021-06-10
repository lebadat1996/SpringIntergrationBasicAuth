package com.training.springboot.productmanager.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class JMSUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(JMSUtils.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendFolderUrlMessage(String fullPath, String queueName) throws Exception {
        LOGGER.info("sendMessage: START at -" + LocalDateTime.now());
        LOGGER.info("sendMessage: fullPath = " + fullPath);
        LOGGER.info("sendMessage: queueName = " + queueName);
        String correlationID = UUID.randomUUID().toString();
        LOGGER.info("sendMessage: correlationID = " + correlationID);
        jmsTemplate.convertAndSend(queueName, fullPath, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws JMSException {
                message.setJMSCorrelationID(correlationID);
                return message;
            }
        });
        LOGGER.info("Send Message to Queue" + queueName + " at " + LocalDateTime.now());
        LOGGER.info("sendMessage: End");
    }

}

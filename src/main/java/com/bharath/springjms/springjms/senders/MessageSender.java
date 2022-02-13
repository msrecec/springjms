package com.bharath.springjms.springjms.senders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Component
public class MessageSender {

    private JmsTemplate jmsTemplate;

    @Value("${springjms.myQueue}")
    private String queue;

    @Autowired
    public MessageSender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void send(String message) {

        MessageCreator mc = s -> s.createTextMessage(message);

        jmsTemplate.send(queue, mc);
    }

}

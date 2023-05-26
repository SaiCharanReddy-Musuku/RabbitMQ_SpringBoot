package com.charan.springbootrabbitmqtutorial.producer;

import com.charan.springbootrabbitmqtutorial.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonProducer {
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.jsonRoutingKey.name}")
    private String jsonRoutingKey;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonProducer.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(User user){
        LOGGER.info(String.format("Json Message Sent -> %s",user.toString()));
        rabbitTemplate.convertAndSend(exchange,jsonRoutingKey,user);
    }
}

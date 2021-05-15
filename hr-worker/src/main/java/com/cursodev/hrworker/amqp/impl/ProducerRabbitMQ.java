package com.cursodev.hrworker.amqp.impl;

import com.cursodev.hrworker.amqp.AmqpProducer;
import com.cursodev.hrworker.dto.MessageDto;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProducerRabbitMQ implements AmqpProducer<MessageDto> {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.routing-key.producer}")
    private String queue;

    @Value("${spring.rabbitmq.exchange.producer}")
    private String exchange;

    @Override
    public void producer(MessageDto messageDto) {
            try {
                rabbitTemplate.convertAndSend(exchange, queue, messageDto);
            }catch (Exception e){
                throw new AmqpRejectAndDontRequeueException(e);
            }
    }
}

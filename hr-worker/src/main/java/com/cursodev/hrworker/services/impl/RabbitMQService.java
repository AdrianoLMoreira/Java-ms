package com.cursodev.hrworker.services.impl;

import com.cursodev.hrworker.amqp.AmqpProducer;
import com.cursodev.hrworker.dto.MessageDto;
import com.cursodev.hrworker.services.AmqpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService implements AmqpService {

    @Autowired
    private AmqpProducer<MessageDto> amqp;

    @Override
    public void sendToConsume(MessageDto message) {
        amqp.producer(message);
    }
}

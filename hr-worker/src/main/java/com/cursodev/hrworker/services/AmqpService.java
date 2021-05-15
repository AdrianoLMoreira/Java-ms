package com.cursodev.hrworker.services;

import com.cursodev.hrworker.dto.MessageDto;

public interface AmqpService {
    void sendToConsume(MessageDto message);
}

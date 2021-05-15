package com.cursodev.hrworker.api;

import com.cursodev.hrworker.dto.MessageDto;
import com.cursodev.hrworker.services.AmqpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rabbit")
public class AmqpApi {

    @Autowired
    private AmqpService service;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/send")
    public void sendToConsumer(@RequestBody MessageDto message){
            service.sendToConsume(message);
    }
}

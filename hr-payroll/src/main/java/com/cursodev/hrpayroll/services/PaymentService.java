package com.cursodev.hrpayroll.services;

import com.cursodev.hrpayroll.entities.Payment;
import com.cursodev.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${worker.local.host}")
    private String workerLocalHost;

    @Autowired
    private RestTemplate restTemplate;

    public Payment getPayment(Long workerId, int days){
        Map<String, String> uriVasriables = new HashMap<>();
        uriVasriables.put("id", workerId.toString());
        Worker worker = restTemplate.getForObject(workerLocalHost+"/workers/{id}", Worker.class, uriVasriables);
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }


}

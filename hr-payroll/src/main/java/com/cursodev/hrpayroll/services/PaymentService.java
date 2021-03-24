package com.cursodev.hrpayroll.services;

import com.cursodev.hrpayroll.entities.Payment;
import com.cursodev.hrpayroll.entities.Worker;
import com.cursodev.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    WorkerFeignClient workerFeignClient;

    public Payment getPayment(Long workerId, int days){
        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }


}
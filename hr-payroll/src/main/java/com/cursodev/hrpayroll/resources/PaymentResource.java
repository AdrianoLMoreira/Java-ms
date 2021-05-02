package com.cursodev.hrpayroll.resources;

import com.cursodev.hrpayroll.entities.Payment;
import com.cursodev.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {
    @Autowired
    private PaymentService paymentService;

    @GetMapping(value="/teste")
    public ResponseEntity<String> teste(){return ResponseEntity.ok("Teste funcionando");}

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping(value="/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable("workerId") Long workerId, @PathVariable("days") Integer days){

//        try {
//            Thread.sleep(7000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Payment payment = paymentService.getPayment(workerId, days);
        return ResponseEntity.ok(payment);
    }

    public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days){
        Payment payment = new Payment("Bruce", 300.0, days);
        return ResponseEntity.ok(payment);
    }
}

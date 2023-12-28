package com.hanniel.worker.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentSuccessProducer {

    @Autowired
    AmqpTemplate amqpTemplate;

    public void generateResponse(String message){
        amqpTemplate.convertAndSend(
                "payment-response-success-exchange",
                "payment-response-success-rout-key",
                message
        );
    }
}

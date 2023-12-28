package com.hanniel.api.consumer;

import com.hanniel.api.facade.PaymentFacede;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PaymentResponseErrorConsumer {
    @Autowired
    PaymentFacede paymentFacede;

    @RabbitListener(queues = {"payment-response-error-queue"})
    public void receive(@Payload Message message){
        System.out.println("Message " + message + "  " + LocalDateTime.now());
        String payload = String.valueOf(message.getPayload());

        paymentFacede.erroPayment(payload);
    }
}

package com.hanniel.worker.consumer;

import com.hanniel.worker.producer.PaymentErrorProducer;
import com.hanniel.worker.producer.PaymentSuccessProducer;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PaymentRequestConsumer {

    @Autowired
    PaymentErrorProducer errorProducer;

    @Autowired
    PaymentSuccessProducer successProducer;


    @RabbitListener(queues = {"payment-request-queue"})
    public void receiverMessage(@Payload Message message){
        System.out.println(message);
        if(new Random().nextBoolean()){
            successProducer.generateResponse("payment is processed with success" + message);
        } else {
            errorProducer.generateResponse("Error: Payment is not processed" + message);
        }
    }
}

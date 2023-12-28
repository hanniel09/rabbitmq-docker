package com.hanniel.api.facade;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hanniel.api.dto.PaymentDTO;
import com.hanniel.api.producer.PaymentRequestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentFacede {

    @Autowired
    PaymentRequestProducer producer;

    public String requestPayment(PaymentDTO paymentDTO) {
        try {
            producer.toIntegrate(paymentDTO);
        } catch (JsonProcessingException e) {
            return "error to request payment" + e.getMessage();
        }
        return "payment awaiting confirmation...";
    }

    public void erroPayment(String payload) {
        System.err.println("ERROR: " + payload);
    }

    public void successPayment(String payload) {
        System.out.println("Success: " + payload);
    }
}

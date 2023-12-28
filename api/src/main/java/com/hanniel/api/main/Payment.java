package com.hanniel.api.main;

import com.hanniel.api.dto.PaymentDTO;
import com.hanniel.api.facade.PaymentFacede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class Payment {
    @Autowired
    PaymentFacede paymentFacede;

    @PostMapping
    public String process(@RequestBody PaymentDTO paymentDTO){
        return paymentFacede.requestPayment(paymentDTO);
    }
}

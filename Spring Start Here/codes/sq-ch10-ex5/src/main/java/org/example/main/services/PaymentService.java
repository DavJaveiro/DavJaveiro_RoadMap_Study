package org.example.main.services;

import org.example.main.exception.NotEnoughMoneyException;
import org.example.main.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }



}

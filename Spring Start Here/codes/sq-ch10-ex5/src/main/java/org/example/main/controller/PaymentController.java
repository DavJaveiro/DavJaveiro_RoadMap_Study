package org.example.main.controller;

import org.apache.coyote.Response;
import org.example.main.error.ErrorDetails;
import org.example.main.exception.NotEnoughMoneyException;
import org.example.main.model.PaymentDetails;
import org.example.main.services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment() {
        try {

            /*Tentamos chamar o méthod processPayment() do serviço*/
            PaymentDetails paymentDetails = paymentService.processPayment();

            /*Se a chamada do method service for bem sucedida, respondemos com o status Accepted and the PaymentDetails instance as a response body*/
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(paymentDetails);

        } catch (NotEnoughMoneyException e) {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setMessage("Not enough money to make the payment.");

            /*Se não, lancará uma exceção do tipo NotEnoughMoneyException, retornamos uma resposta HPTT com status BadRequest e uma instäncia de ErrorDetails no corpo*/
            return ResponseEntity
                    .badRequest()
                    .body(errorDetails);
        }
    }
}

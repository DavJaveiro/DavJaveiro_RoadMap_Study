package org.example.main.controller;

import org.example.main.model.Payment;
import org.example.main.proxy.PaymentsProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentsController {

    private final PaymentsProxy paymentsProxy;

    public PaymentsController(PaymentsProxy paymentsProxy) {
        this.paymentsProxy = paymentsProxy;
    }

    @PostMapping("/payment")
    public Payment createPayment(
            @RequestBody Payment payment
    ) {
        /*Nós chamamos o méthod proxy, que por sua vez chama o endpoint do serviço de pagamentos. Nós obtemos o corpo da resposta e o retornamos ao cliente*/
        return paymentsProxy.createPayment(payment);
    }
}

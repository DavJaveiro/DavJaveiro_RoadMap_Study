package org.example.main.proxy;

import org.example.main.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/*We use the @FeignClient annotation to configure the REST client. A minimal configuration defines a name and the endpoint base URI*/
@FeignClient(name = "payments",
        url = "${name.service.url}")
public interface PaymentsProxy {

    @PostMapping("/payment")
    Payment createPayment(
            @RequestHeader String requestId,
            @RequestBody Payment payment);
}

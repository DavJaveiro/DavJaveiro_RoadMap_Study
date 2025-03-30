package org.example.sqch15ex1.controller;

import org.example.sqch15ex1.dto.TransferRequest;
import org.example.sqch15ex1.model.Account;
import org.example.sqch15ex1.service.TransferService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    private final TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest request) {
        transferService.transferMoney(
                request.getSenderAccountId(),
                request.getReceiverAccountId(),
                request.getAmount()
        );

    }

    public Iterable<Account> getAccounts(@RequestParam(required = false) String name) {
        if (name == null) {
            return transferService.getAccounts();
        } else {
            return transferService.getAccountsByName(name);
        }
    }

}

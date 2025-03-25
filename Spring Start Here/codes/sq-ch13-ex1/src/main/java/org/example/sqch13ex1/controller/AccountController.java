package org.example.sqch13ex1.controller;

import org.example.sqch13ex1.dto.TransferRequest;
import org.example.sqch13ex1.model.Account;
import org.example.sqch13ex1.service.TransferService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return transferService.getAllAccounts();
    }

}

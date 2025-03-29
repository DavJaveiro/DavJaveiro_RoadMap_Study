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
    public Iterable<Account> getAllAccounts(@RequestParam(required = false) String name) {
        if (name == null) { // if no name in the optional request parameter, we return all the account details
            return transferService.getAllAccounts();
        } else { // if a name is provided in the request parameter, we only return the account details for the given name
            return transferService.findAccountsByName(name);
        }
    }

}

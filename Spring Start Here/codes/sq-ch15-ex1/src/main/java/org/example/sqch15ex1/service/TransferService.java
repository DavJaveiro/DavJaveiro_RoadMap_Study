package org.example.sqch15ex1.service;

import org.example.sqch15ex1.exceptions.AccountNotFoundException;
import org.example.sqch15ex1.model.Account;
import org.example.sqch15ex1.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {
    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void transferMoney(int idSender, int idReceiver, BigDecimal amount) {
        Account sender = accountRepository.findById(idSender).orElseThrow(() -> new AccountNotFoundException());

        Account receiver = accountRepository.findById(idReceiver).orElseThrow(() -> new AccountNotFoundException());

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverAmount = receiver.getAmount().add(amount);

        accountRepository.changeAmount(idSender, senderNewAmount);

        accountRepository.changeAmount(idReceiver, receiverAmount);
    }

    public Iterable<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public List<Account> getAccountsByName(String name) {
        return accountRepository.findAccountsByName(name);
    }
}

package org.example.sqch13ex1.service;

import org.example.sqch13ex1.exceptions.AccountNotFoundException;
import org.example.sqch13ex1.model.Account;
import org.example.sqch13ex1.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {

    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(Long idSender, Long idReceiver, BigDecimal amount)  {
        Account sender = accountRepository.findById(idSender).orElseThrow(() -> new AccountNotFoundException());
        Account receiver = accountRepository.findById(idReceiver).orElseThrow(() -> new AccountNotFoundException());

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        accountRepository.changeAmount(idSender, senderNewAmount);
        accountRepository.changeAmount(idReceiver, receiverNewAmount);

    }

    public Iterable<Account> getAllAccounts() {
        return accountRepository.findAlAccounts();
    }

    public List<Account> findAccountsByName(String name) {
        return accountRepository.findAccountsByName(name);
    }
}

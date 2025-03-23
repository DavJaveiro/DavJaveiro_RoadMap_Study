package org.example.sqch13ex1.service;

import org.example.sqch13ex1.model.Account;
import org.example.sqch13ex1.repository.AccountRepository;
import org.springframework.cache.annotation.AbstractCachingConfiguration;
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
    public void transferMoney(Long idSender, Long idReceiver, BigDecimal amount) {
        Account sender = accountRepository.findAccountById(idSender);

        Account receiver = accountRepository.findAccountById(idReceiver);

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().subtract(amount);

        accountRepository.changeAmount(idSender, senderNewAmount);

        accountRepository.changeAmount(idReceiver, receiverNewAmount);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAllAccounts();
    }
}

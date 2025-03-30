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

        /*We find the details of the sender's account*/
        Account sender = accountRepository.findById(idSender).orElseThrow(() -> new AccountNotFoundException());

        /*We find the details of the destination account*/
        Account receiver = accountRepository.findById(idReceiver).orElseThrow(() -> new AccountNotFoundException());

        /*We calculate the account's amounts*/
        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        /*We update the new amount in the sender account*/
        accountRepository.changeAmount(idSender, senderNewAmount);

        /*We update the new amount in the destination account*/
        accountRepository.changeAmount(idReceiver, receiverNewAmount);

    }

    public Iterable<Account> getAllAccounts() {
        return accountRepository.findAlAccounts();
    }

    public List<Account> findAccountsByName(String name) {
        return accountRepository.findAccountsByName(name);
    }
}

package org.example.sqch15ex1;

import org.example.sqch15ex1.model.Account;
import org.example.sqch15ex1.repository.AccountRepository;
import org.example.sqch15ex1.service.TransferService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TransferServiceUnitTests {

    /*Criando um mock da interface*/
    @Mock
    private AccountRepository accountRepository;

    private TransferService transferService;

    @Test
    @DisplayName("Test the amount is transferred from one account to another if no exception occurs.")
    public void moneyTransferHappyFlow() {

        /*Premissas (Given)*/
        AccountRepository accountRepository = mock(AccountRepository.class);
        TransferService transferService = new TransferService(accountRepository);

        Account sender = new Account(1, "João", new BigDecimal("1000"));
        Account destination = new Account(2, "Chaves", new BigDecimal("2000"));

        /*Comportamento do Mock, method Given*/
        given(accountRepository.findById(sender.getId()))
                .willReturn(Optional.of(sender));
        given(accountRepository.findById(destination.getId()))
                .willReturn(Optional.of(destination));

        /*Chamada (When)*/
        transferService.transferMoney(1, 2, new BigDecimal(100));

        /*Validações (Then)*/
        verify(accountRepository).changeAmount(1, new BigDecimal(900));
        verify(accountRepository).changeAmount(2, new BigDecimal(2100));
    }

}

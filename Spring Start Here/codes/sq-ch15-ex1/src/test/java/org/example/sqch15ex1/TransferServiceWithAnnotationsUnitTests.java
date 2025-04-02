package org.example.sqch15ex1;

import org.example.sqch15ex1.exceptions.AccountNotFoundException;
import org.example.sqch15ex1.model.Account;
import org.example.sqch15ex1.repository.AccountRepository;
import org.example.sqch15ex1.service.TransferService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/*Permite o uso da anotação @Mock para criar mocks sem precisar inicializá-los manualmente*/
// Permite o uso da anotação @InjectMocks para injetar dependências mockadas automaticamente
// Facilita a manutenção e organização dos testes, deixando o código mais limpo
@ExtendWith(MockitoExtension.class)
public class TransferServiceWithAnnotationsUnitTests {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private TransferService transferService;

    @Test
    public void moneyTransferHappyFlow() {
        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        Account destination = new Account();
        destination.setId(2);
        destination.setAmount(new BigDecimal(1000));

        given(accountRepository.findById(sender.getId()))
                .willReturn(Optional.of(sender));

        given(accountRepository.findById(destination.getId()))
                .willReturn(Optional.of(destination));

        transferService.transferMoney(1, 2, new BigDecimal(100));

        verify(accountRepository).changeAmount(1, new BigDecimal(900));
        verify(accountRepository).changeAmount(2, new BigDecimal(1100));
    }

    @Test
    public void moneyTransferDestinationAccountNotFoundFlow() {
        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        given(accountRepository.findById(1))
                .willReturn(Optional.of(sender));

        given(accountRepository.findById(2))
                .willReturn(Optional.empty());

        assertThrows(
                AccountNotFoundException.class,
                () -> transferService.transferMoney(1, 2, new BigDecimal(100))
        );

        verify(accountRepository, never())
                .changeAmount((int) anyLong(), any());
    }
}

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

import static net.bytebuddy.matcher.ElementMatchers.any;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.client.ExpectedCount.never;

import java.math.BigDecimal;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class TransferServiceWithAnnotationUnitTests {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private TransferService transferService;

    @Test
    public void moneyTransferDestinationAccountNotFoundFlow() {
        Account sender = new Account(1, "João", new BigDecimal("1000"));

//        Account destination = new Account(2, "Chaves", new BigDecimal("2000"));

        given(accountRepository.findById(1)).willReturn(Optional.of(sender));
        given(accountRepository.findById(2)).willReturn(Optional.empty());

        assertThrows(AccountNotFoundException.class, () -> transferService.transferMoney(1, 2, new BigDecimal(100)));

        verify(accountRepository, never()).changeAmount(anyLong(), any());
    }
}

package org.example.sqch13ex1;

import org.example.sqch13ex1.model.Account;
import org.example.sqch13ex1.repository.AccountRepository;
import org.example.sqch13ex1.service.TransferService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class TransferServiceUnitTests {

    @Test
    @DisplayName("Testa se o valor é transferido de uma conta para a outra sem nenhuma exceção ocorrer")
    public void moneyTrasnferHappyFlow() {

        /*usamos o method mock() do Mockito para criar uma isntância fictícia (mock) para o objeto AccountRepository*/
        AccountRepository accountRepository = mock(AccountRepository.class);

        /*Criamos uma instância do objeto TransferService cujo method queremos testar. Em vez de uma instância real do AccountRepository, criamos o objeto usando um AccountRepository mockado.*/
        TransferService transferService = new TransferService(accountRepository);

        /*We create the sender Account instances*/
        Account sender = new Account();
        sender.setId(1L);
        sender.setAmount(new BigDecimal(1000));

        Account destination = new Account();
        destination.setId(2L);
        destination.setAmount(new BigDecimal(2000));

        /*simulamos a resposta do method findById() para que, no teste, ele retorne a conta desejada, ou seja, a que estamos fornecendo e criando dentro da classe HappyFlow*/
        given(accountRepository.findById(sender.getId())).willReturn(Optional.of(sender));
        given(accountRepository.findById(destination.getId())).willReturn(Optional.of(destination));

        transferService.transferMoney(
                sender.getId(),
                destination.getId(),
                new BigDecimal(100)
        );

        verify(accountRepository).changeAmount(1L, new BigDecimal(900));

        verify(accountRepository).changeAmount(2L, new BigDecimal(2100));
    }

}

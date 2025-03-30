package org.example.sqch15ex1.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class TransferRequest {

    @Positive(message = "O ID da conta do remetente deve ser um número positivo!")
    private int senderAccountId;

    @Positive(message = "O ID da conta do destinatário deve ser um número positivo!")
    private int receiverAccountId;

    @NotNull(message = "O valor da transferência não pode ser um valor nulo!")
    @Positive(message = "O valor da transferência deve ser representado por um valor positivo!")
    private BigDecimal amount;

    public int getSenderAccountId() {
        return senderAccountId;
    }

    public void setSenderAccountId(int senderAccountId) {
        this.senderAccountId = senderAccountId;
    }

    public int getReceiverAccountId() {
        return receiverAccountId;
    }

    public void setReceiverAccountId(int receiverAccountId) {
        this.receiverAccountId = receiverAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}

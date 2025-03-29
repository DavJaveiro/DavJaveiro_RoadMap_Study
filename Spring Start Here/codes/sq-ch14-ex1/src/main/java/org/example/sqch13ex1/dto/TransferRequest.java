package org.example.sqch13ex1.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class TransferRequest {

    @Positive(message = "O ID da conta do rementente deve ser um número positivo!")
    private long senderAccountId;

    @Positive(message = "O ID da conta do destinatário deve ser um número positivo!")
    private long receiverAccountId;

    @NotNull(message = "O valor da transferência não pode ser um valor nulo!")
    @Positive(message = "O valor da transferência deve ser representado por um valor positivo!")
    private BigDecimal amount;

    public long getSenderAccountId() {
        return senderAccountId;
    }

    public void setSenderAccountId(long senderAccountId) {
        this.senderAccountId = senderAccountId;
    }

    public long getReceiverAccountId() {
        return receiverAccountId;
    }

    public void setReceiverAccountId(long receiverAccountId) {
        this.receiverAccountId = receiverAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}

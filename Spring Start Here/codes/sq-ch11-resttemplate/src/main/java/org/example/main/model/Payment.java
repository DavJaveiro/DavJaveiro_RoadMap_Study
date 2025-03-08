package org.example.main.model;

public class Payment {
    private String paymentId;
    private double amount;

    public Payment(){}

    public Payment(String paymentId, double amount) {
        this.paymentId = paymentId;
        this.amount = amount;
    }

    public void setPayment(String paymentId, double amount) { {
    this.paymentId = paymentId;
    this.amount = amount;}
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public double getAmount() {
        return amount;
    }
}


package org.example.main.controller;

import org.example.main.error.ErrorDetails;
import org.example.main.exception.NotEnoughMoneyException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<?> exceptionNotEnoughMoney() {
        ErrorDetails errorDetails =  new ErrorDetails();

        errorDetails.setMessage("Not enough money to make the payment");

        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }
}

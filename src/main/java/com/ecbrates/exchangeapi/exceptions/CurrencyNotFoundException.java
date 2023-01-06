package com.ecbrates.exchangeapi.exceptions;

public class CurrencyNotFoundException extends RuntimeException {
    public CurrencyNotFoundException() {
        super(String.format("Currency not found"));
    }
}
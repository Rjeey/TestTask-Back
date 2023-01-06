package com.ecbrates.exchangeapi.exceptions;

public class DateNotFoundException extends RuntimeException {
    public DateNotFoundException() {
        super(String.format("Latest date found"));
    }
}
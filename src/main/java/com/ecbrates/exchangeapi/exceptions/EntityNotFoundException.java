package com.ecbrates.exchangeapi.exceptions;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message, Long id) {
        super(String.format("%s with Id %d not found", message, id));
    }

    public EntityNotFoundException(String message, String name) {
        super(String.format("%s with name %s not found ", message, name));
    }
}
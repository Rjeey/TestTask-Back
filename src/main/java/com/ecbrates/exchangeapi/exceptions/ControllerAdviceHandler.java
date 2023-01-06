package com.ecbrates.exchangeapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdviceHandler extends ResponseEntityExceptionHandler {
    private static final String MESSAGE = "message";
    private static final String TIME_STAMP = "timestamp";

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(
            EntityNotFoundException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put(MESSAGE, LocalDateTime.now());
        body.put(TIME_STAMP, ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = Exception.class)
    public ErrorMessage handleUnknownException(Exception ex, WebRequest request) {
        return new ErrorMessage(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
    }

    @ExceptionHandler(value = CurrencyNotFoundException.class)
    public ErrorMessage handleCurrencyNotFoundException(Exception ex, WebRequest request) {
        return new ErrorMessage(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
    }
}
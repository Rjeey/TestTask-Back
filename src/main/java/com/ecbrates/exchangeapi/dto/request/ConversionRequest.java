package com.ecbrates.exchangeapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ConversionRequest {

    private String currencyFrom;
    private String currencyTo;
    private BigDecimal fromValue;
}

package com.ecbrates.exchangeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRateDTO {
    private Long id;
    private String currency;
    private Double rate;
    private Date ecbDate;
}
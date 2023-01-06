package com.ecbrates.exchangeapi.controllers;

import com.ecbrates.exchangeapi.dto.ExchangeRateDTO;
import com.ecbrates.exchangeapi.services.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/exchanges")
@RequiredArgsConstructor
public class ExchangeController {
    private final ExchangeService exchangeService;

    @GetMapping("/rates")
    public List<ExchangeRateDTO> getExchangeRates() {
        return exchangeService.getExchangeRates();
    }

}
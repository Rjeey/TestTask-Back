package com.ecbrates.exchangeapi.services;

import com.ecbrates.exchangeapi.dto.ExchangeRateDTO;
import com.ecbrates.exchangeapi.entity.ExchangeRate;
import com.ecbrates.exchangeapi.mapper.ExchangeRateMapper;
import com.ecbrates.exchangeapi.repositories.ExchangeRepository;
import com.ecbrates.exchangeapi.utils.parser.Envelope;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
@Transactional
public class ExchangeService {
    private final WebClient webClient;
    private final ExchangeRepository exchangeRepository;
    private final ExchangeRateMapper exchangeRateMapper;



    public List<ExchangeRate> getExchanges() {
        List<ExchangeRate> exchangeRates = exchangeRepository.findByEcbDate(toDay());

        if (exchangeRates.isEmpty()) {
            ExchangeRate latestRate = exchangeRepository.findFirstByOrderByEcbDateDesc();
            if (latestRate == null) {
                exchangeRates = loadExchanges();
            } else {
                exchangeRates = exchangeRepository.findByEcbDate(latestRate.getEcbDate());
            }
        }
        return exchangeRates;
    }

    public List<ExchangeRate> loadExchanges() {
        Envelope block = getEnvelope();
        if (block == null) {
            return new ArrayList<>();
        } else {
            List<ExchangeRate> exchangeRates = exchangeRateMapper.destinationToSource(block);
            exchangeRepository.saveAll(exchangeRates);
            return exchangeRates;
        }
    }

    public List<ExchangeRateDTO> getExchangeRates() {
        return exchangeRateMapper.destinationToListSource(getExchanges());
    }

    public Envelope getEnvelope() {
        return webClient
                .get()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE)
                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .retrieve()
                .bodyToMono(Envelope.class)
                .block();
    }

    public LocalDate toDay() {
        return LocalDate.now();
    }
}
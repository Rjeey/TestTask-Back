package com.ecbrates.exchangeapi.repositories;

import com.ecbrates.exchangeapi.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExchangeRepository extends JpaRepository<ExchangeRate, Long> {

    List<ExchangeRate> findByEcbDate(LocalDate date);

    ExchangeRate findFirstByOrderByEcbDateDesc();

}

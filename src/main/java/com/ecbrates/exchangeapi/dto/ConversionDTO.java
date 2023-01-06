package com.ecbrates.exchangeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConversionDTO {
    private Long id;
    private String conversionFrom;
    private String conversionTo;
    private BigDecimal rateFrom;
    private BigDecimal rateTo;
    private BigDecimal fromValue;
    private BigDecimal toValue;
    private LocalDate ecbDate;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private Long authorId;
    private String authorUsername;

}
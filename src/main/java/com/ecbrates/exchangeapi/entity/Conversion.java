package com.ecbrates.exchangeapi.entity;

import com.ecbrates.exchangeapi.entity.security.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Conversion extends AbstractEntity {

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "conversion_from_id")
    private ExchangeRate fromExchange;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "conversion_to_id")
    private ExchangeRate toExchange;

    private LocalDate ecbDate;

    private BigDecimal fromValue;
    private BigDecimal toValue;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "author_id")
    private User user;

}
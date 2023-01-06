package com.ecbrates.exchangeapi.utils.parser;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CurrencyCube", namespace = "http://www.ecb.int/vocabulary/2002-08-01/eurofxref")
@Data
public class CurrencyCube {

    @XmlAttribute(name = "currency", required = true)
    private String currency;

    @XmlAttribute(name = "rate", required = true)
    private BigDecimal rate;

}
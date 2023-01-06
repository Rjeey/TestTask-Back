package com.ecbrates.exchangeapi.utils.parser;

import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimeCube", propOrder = {
        "cube"
})
@Data
public class TimeCube {

    @XmlElement(name = "Cube", namespace = "http://www.ecb.int/vocabulary/2002-08-01/eurofxref")
    private List<CurrencyCube> cube;

    @XmlAttribute(name = "time")
    @XmlSchemaType(name = "date")
    private XMLGregorianCalendar time;

}
package com.ecbrates.exchangeapi.utils.parser;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
@XmlRootElement(name = "Envelope", namespace = "http://www.gesmes.org/xml/2002-08-01")
public class Envelope {

    @XmlElement(name = "Cube", namespace = "http://www.ecb.int/vocabulary/2002-08-01/eurofxref")
    protected Cube cube;
    @XmlElement(name = "subject", namespace = "http://www.gesmes.org/xml/2002-08-01")
    private String subject;
    @XmlElement(name = "Sender", namespace = "http://www.gesmes.org/xml/2002-08-01")
    private Sender sender;

}
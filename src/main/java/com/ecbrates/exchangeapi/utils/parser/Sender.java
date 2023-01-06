package com.ecbrates.exchangeapi.utils.parser;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Sender {

    @XmlElement(name = "name", namespace = "http://www.gesmes.org/xml/2002-08-01")
    private String name;

}
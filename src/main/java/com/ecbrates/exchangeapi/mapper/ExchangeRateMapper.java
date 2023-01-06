package com.ecbrates.exchangeapi.mapper;

import com.ecbrates.exchangeapi.dto.ExchangeRateDTO;
import com.ecbrates.exchangeapi.entity.ExchangeRate;
import com.ecbrates.exchangeapi.utils.parser.CurrencyCube;
import com.ecbrates.exchangeapi.utils.parser.Envelope;
import com.ecbrates.exchangeapi.utils.parser.TimeCube;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ExchangeRateMapper {

    ExchangeRate sourceToDestination(ExchangeRateDTO source);

    ExchangeRateDTO destinationToSource(ExchangeRate destination);

    List<ExchangeRateDTO> destinationToListSource(List<ExchangeRate> source);

    default List<ExchangeRate> destinationToSource(Envelope envelope) {
        TimeCube timeCube = envelope.getCube().getCube().get(0);

        XMLGregorianCalendar time = timeCube.getTime();
        LocalDate date = LocalDate.of(time.getYear(), time.getMonth(), time.getDay());
        List<ExchangeRate> exchangeRate = currencyCubeToExchangeDTO(timeCube.getCube());
        exchangeRate.forEach(exchangeRateDTO -> exchangeRateDTO.setEcbDate(date));
        return exchangeRate;
    }

    List<ExchangeRate> currencyCubeToExchangeDTO(List<CurrencyCube> currencyCube);

}
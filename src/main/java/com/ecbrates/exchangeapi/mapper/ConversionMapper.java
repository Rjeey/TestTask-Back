package com.ecbrates.exchangeapi.mapper;

import com.ecbrates.exchangeapi.dto.ConversionDTO;
import com.ecbrates.exchangeapi.entity.Conversion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ConversionMapper {

    @Mapping(source = "fromExchange.currency", target = "conversionFrom")
    @Mapping(source = "toExchange.currency", target = "conversionTo")
    @Mapping(source = "fromExchange.rate", target = "rateFrom")
    @Mapping(source = "toExchange.rate", target = "rateTo")
    @Mapping(source = "user.id", target = "authorId")
    @Mapping(source = "user.login", target = "authorUsername")
    ConversionDTO destinationToSource(Conversion conversion);

    List<ConversionDTO> destinationToSourceList(List<Conversion> users);

}
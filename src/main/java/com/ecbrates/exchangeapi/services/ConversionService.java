package com.ecbrates.exchangeapi.services;

import com.ecbrates.exchangeapi.dto.ConversionDTO;
import com.ecbrates.exchangeapi.dto.request.ConversionRequest;
import com.ecbrates.exchangeapi.entity.Conversion;
import com.ecbrates.exchangeapi.entity.ExchangeRate;
import com.ecbrates.exchangeapi.entity.security.User;
import com.ecbrates.exchangeapi.exceptions.CurrencyNotFoundException;
import com.ecbrates.exchangeapi.exceptions.EntityNotFoundException;
import com.ecbrates.exchangeapi.mapper.ConversionMapper;
import com.ecbrates.exchangeapi.repositories.ConversionRepository;
import com.ecbrates.exchangeapi.repositories.UserRepository;
import com.ecbrates.exchangeapi.security.model.UserDetailsImpl;
import com.ecbrates.exchangeapi.utils.AuthenticatedUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ConversionService {

    private static final String EXCEPTION_SERVICE = "Conversion";

    private final ConversionRepository conversionRepository;
    private final UserRepository userRepository;
    private final ExchangeService exchangeService;
    private final ConversionMapper conversionMapper;

    public List<ConversionDTO> getMyConversions() {
        return Optional.ofNullable(AuthenticatedUser.getAuthenticatedUser())
                .map(UserDetailsImpl::getId)
                .map(conversionRepository::findAllByUser_Id)
                .map(conversionMapper::destinationToSourceList)
                .orElseThrow();
    }

    public List<ConversionDTO> getAllConversions() {
        List<Conversion> conversions = conversionRepository.findAll();
        return conversionMapper.destinationToSourceList(conversions);
    }

    public ConversionDTO getConversionById(Long id) {
        return conversionRepository.findById(id)
                .map(conversionMapper::destinationToSource)
                .orElseThrow(() -> new EntityNotFoundException(EXCEPTION_SERVICE, id));
    }

    public ConversionDTO convert(ConversionRequest conversionRequest) {
        Long userId = AuthenticatedUser.getAuthenticatedUser().getId();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(EXCEPTION_SERVICE, userId));

        List<ExchangeRate> exchangeRateDTOS = exchangeService.getExchanges();

        ExchangeRate exchangeRateFrom = takeExchangeRateByCurrency(exchangeRateDTOS, conversionRequest.getCurrencyFrom());
        ExchangeRate exchangeRateTo = takeExchangeRateByCurrency(exchangeRateDTOS, conversionRequest.getCurrencyTo());

        LocalDate ecbDate = exchangeRateFrom.getEcbDate();

        BigDecimal fromValue = conversionRequest.getFromValue();
        BigDecimal toValue = resultValueByRate(fromValue, exchangeRateFrom.getRate(), exchangeRateTo.getRate());
        Conversion conversion = Conversion.builder()
                .fromExchange(exchangeRateFrom)
                .toExchange(exchangeRateTo)
                .ecbDate(ecbDate)
                .fromValue(fromValue)
                .toValue(toValue)
                .user(user).build();
        conversionRepository.save(conversion);

        return conversionMapper.destinationToSource(conversion);
    }

    private BigDecimal resultValueByRate(BigDecimal fromValue, BigDecimal fromRate, BigDecimal toRate) {
        return fromValue.divide(fromRate, MathContext.DECIMAL128).multiply(toRate).setScale(3, RoundingMode.HALF_EVEN);
    }

    private ExchangeRate takeExchangeRateByCurrency(List<ExchangeRate> exchangeRates, String currency) {
        return exchangeRates.stream()
                .filter(exchangeRateDTO -> currency.equals(exchangeRateDTO.getCurrency()))
                .findFirst()
                .orElseThrow(CurrencyNotFoundException::new);
    }

}
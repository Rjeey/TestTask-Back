package com.ecbrates.exchangeapi.controllers;

import com.ecbrates.exchangeapi.dto.ConversionDTO;
import com.ecbrates.exchangeapi.dto.request.ConversionRequest;
import com.ecbrates.exchangeapi.services.ConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/conversions")
@RequiredArgsConstructor
public class ConversionController {

    private final ConversionService conversionService;

    @GetMapping
    public List<ConversionDTO> getMyConversions() {
        return conversionService.getMyConversions();
    }

    @GetMapping("/all")
    public List<ConversionDTO> getAllConversions() {
        return conversionService.getAllConversions();
    }

    @GetMapping("/{id}")
    public ConversionDTO getConversionById(@PathVariable Long id) {
        return conversionService.getConversionById(id);
    }

    @PostMapping
    public ConversionDTO convert(@RequestBody ConversionRequest conversionRequest) {
        return conversionService.convert(conversionRequest);
    }

}
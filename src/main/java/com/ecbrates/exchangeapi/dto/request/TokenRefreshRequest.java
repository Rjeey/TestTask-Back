package com.ecbrates.exchangeapi.dto.request;

import lombok.Data;

@Data
public class TokenRefreshRequest {

    private String refreshToken;
}
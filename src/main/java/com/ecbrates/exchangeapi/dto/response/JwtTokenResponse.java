package com.ecbrates.exchangeapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JwtTokenResponse {

    private String token;
    private String type;
    private Long id;
    private String username;
    private List<String> roles;

    private String refreshToken;
}
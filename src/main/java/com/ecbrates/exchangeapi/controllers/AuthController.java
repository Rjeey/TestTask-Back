package com.ecbrates.exchangeapi.controllers;

import com.ecbrates.exchangeapi.dto.request.LoginRequest;
import com.ecbrates.exchangeapi.dto.request.TokenRefreshRequest;
import com.ecbrates.exchangeapi.dto.response.JwtTokenResponse;
import com.ecbrates.exchangeapi.dto.response.TokenRefreshResponse;
import com.ecbrates.exchangeapi.exceptions.UserUnauthenticated;
import com.ecbrates.exchangeapi.security.service.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/sign-in")
    public JwtTokenResponse autUser(@RequestBody LoginRequest loginRequest) throws UserUnauthenticated {
        return authService.authenticateUser(loginRequest);
    }

    @PostMapping("/refresh")
    public TokenRefreshResponse refreshToken(@RequestBody TokenRefreshRequest request) {
        return authService.refreshToken(request);
    }
}

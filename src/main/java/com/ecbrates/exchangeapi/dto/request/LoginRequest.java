package com.ecbrates.exchangeapi.dto.request;

import lombok.Data;

@Data
public class LoginRequest {

    private String login;

    private String password;
}

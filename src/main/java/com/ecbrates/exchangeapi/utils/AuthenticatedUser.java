package com.ecbrates.exchangeapi.utils;

import com.ecbrates.exchangeapi.security.model.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthenticatedUser {

    public static UserDetailsImpl getAuthenticatedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl jwtUser = (UserDetailsImpl) auth.getPrincipal();
        return jwtUser;
    }

}
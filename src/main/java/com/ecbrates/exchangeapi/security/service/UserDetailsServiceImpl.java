package com.ecbrates.exchangeapi.security.service;

import com.ecbrates.exchangeapi.entity.security.User;
import com.ecbrates.exchangeapi.repositories.UserRepository;
import com.ecbrates.exchangeapi.security.model.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login)
                .orElseThrow(() -> {
                    log.error("User Not Found with username: " + login);
                   return new UsernameNotFoundException("User Not Found with username: " + login);
                });

        return UserDetailsImpl.build(user);
    }

}
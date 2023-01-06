package com.ecbrates.exchangeapi.repositories;

import com.ecbrates.exchangeapi.entity.RefreshToken;
import com.ecbrates.exchangeapi.entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    Optional<RefreshToken> findByToken(String token);

    @Modifying
    int deleteByUser(User user);
}

package com.ecbrates.exchangeapi.repositories;

import com.ecbrates.exchangeapi.entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByLogin(String login);

    Optional<User> findById(Long id);

    List<User> findAll();
}
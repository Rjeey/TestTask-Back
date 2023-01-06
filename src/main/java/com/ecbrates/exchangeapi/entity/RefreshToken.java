package com.ecbrates.exchangeapi.entity;

import com.ecbrates.exchangeapi.entity.security.User;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Entity(name = "token")
@Data
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(nullable = false, unique = true)
    private String token;

    @Column(nullable = false)
    private Instant expiryDate;

}
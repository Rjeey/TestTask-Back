package com.ecbrates.exchangeapi.entity.security;

import com.ecbrates.exchangeapi.utils.ERole;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "role")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @Enumerated(EnumType.STRING)
    private ERole name;
}

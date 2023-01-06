package com.ecbrates.exchangeapi.entity.security;

import com.ecbrates.exchangeapi.entity.AbstractEntity;
import com.ecbrates.exchangeapi.entity.Conversion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usr")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends AbstractEntity {

    @Column
    private String login;
    @Column
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Conversion> conversionRequests = new ArrayList<>();
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> role;
}
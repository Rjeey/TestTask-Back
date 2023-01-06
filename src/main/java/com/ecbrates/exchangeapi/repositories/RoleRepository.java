package com.ecbrates.exchangeapi.repositories;

import com.ecbrates.exchangeapi.entity.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);
}

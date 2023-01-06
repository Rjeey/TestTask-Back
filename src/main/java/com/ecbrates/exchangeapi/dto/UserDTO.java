package com.ecbrates.exchangeapi.dto;

import com.ecbrates.exchangeapi.entity.security.Role;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.Set;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private Date createdDate;
    private Date updatedDate;
    private Set<Role> role;

}
package com.ecbrates.exchangeapi.mapper;

import com.ecbrates.exchangeapi.dto.UserDTO;
import com.ecbrates.exchangeapi.entity.security.User;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {
    UserDTO destinationToSource(User destination);

    User sourceToDestination(UserDTO destination);

    List<UserDTO> destinationToSourceList(List<User> users);

}
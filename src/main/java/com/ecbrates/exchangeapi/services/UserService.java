package com.ecbrates.exchangeapi.services;

import com.ecbrates.exchangeapi.dto.UserDTO;
import com.ecbrates.exchangeapi.entity.security.User;
import com.ecbrates.exchangeapi.exceptions.EntityNotFoundException;
import com.ecbrates.exchangeapi.mapper.UserMapper;
import com.ecbrates.exchangeapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private static final String EXCEPTION_SERVICE = "User";
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.destinationToSourceList(users);
    }

    public UserDTO findByName(String login) {
        User user = userRepository.findByLogin(login).orElseThrow(() -> new EntityNotFoundException(EXCEPTION_SERVICE, login));
        return userMapper.destinationToSource(user);
    }

    public UserDTO getOneUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(EXCEPTION_SERVICE, id));
        return userMapper.destinationToSource(user);
    }

}
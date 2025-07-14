package com.walletapi.walletapi.services;

import com.walletapi.walletapi.dto.UserRequestDTO;
import com.walletapi.walletapi.dto.UserResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface UserService {
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);
//    List<UserResponseDTO> findAll();
//    Optional<UserResponseDTO> findById(UUID id);
}

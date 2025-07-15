package com.walletapi.walletapi.services;

import com.walletapi.walletapi.dto.UserRequestDTO;
import com.walletapi.walletapi.dto.UserResponseDTO;
import com.walletapi.walletapi.entities.Users;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    UserResponseDTO createUser(UserRequestDTO userRequestDTO);

    List<Users> getAllUsers();
    Optional<Users> getUserById(UUID id);
    Users saveUser(Users users); // optional utility if needed
    void deleteUser(UUID id);
}

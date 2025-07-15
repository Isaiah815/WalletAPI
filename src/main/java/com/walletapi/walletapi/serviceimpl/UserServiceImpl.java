package com.walletapi.walletapi.serviceimpl;

import com.sun.jdi.request.DuplicateRequestException;
import com.walletapi.walletapi.dto.UserRequestDTO;
import com.walletapi.walletapi.dto.UserResponseDTO;
import com.walletapi.walletapi.entities.Users;
import com.walletapi.walletapi.entities.Wallet;
import com.walletapi.walletapi.mappers.UserMapper;
import com.walletapi.walletapi.repository.UserRepository;
import com.walletapi.walletapi.repository.WalletRepository;
import com.walletapi.walletapi.services.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final WalletRepository walletRepository;

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        if (userRepository.existsByEmail(userRequestDTO.getEmail())) {
            throw new DuplicateRequestException("Email already exists");
        }

        Users user = userMapper.toUser(userRequestDTO);
        user = userRepository.save(user);

        Wallet wallet = new Wallet();
        wallet.setUsers(user);
        wallet.setWalletName(user.getUsername());
        wallet.setCreatedBy("zippy");
        wallet.setCreatedOn(LocalDateTime.now());

        walletRepository.save(wallet);

        UserResponseDTO responseDTO = userMapper.toUserResponseDTO(user);
        responseDTO.setWallet(wallet);

        return responseDTO;
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<Users> getUserById(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public Users saveUser(Users users) {
        return userRepository.save(users);
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}

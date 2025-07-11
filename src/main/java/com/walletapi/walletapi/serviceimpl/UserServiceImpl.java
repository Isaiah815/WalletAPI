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
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final WalletRepository walletRepository;


    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        //we are creating user and wallet
        //validation that needs to be done
        //if user exists by email
       //Exceptions may fail to work because we haven't configure
        if(userRepository.existsByEmail(userRequestDTO.getEmail())) {
            throw new DuplicateRequestException("Email already exists");
        }

        Users user = userRepository.save(userMapper.toUser(userRequestDTO));

        //upon successful user we can create a wallet
        //this code of wallet needs to be refactored
        Wallet wallet=new Wallet();
        wallet.setUsers(user);
        wallet.setWalletName(user.getUsername());
        wallet.setCreatedBy("zippy");
        wallet.setCreatedOn(LocalDateTime.now());
        walletRepository.save(wallet);

        UserResponseDTO userResponseDTO=userMapper.toUserResponseDTO(user);
        userResponseDTO.setWallet(wallet);
        return userResponseDTO;

    }
}

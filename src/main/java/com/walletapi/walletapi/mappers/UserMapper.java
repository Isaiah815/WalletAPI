package com.walletapi.walletapi.mappers;

import com.walletapi.walletapi.dto.UserRequestDTO;
import com.walletapi.walletapi.dto.UserResponseDTO;
import com.walletapi.walletapi.entities.Users;
import lombok.RequiredArgsConstructor;

import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;


@Mapper(componentModel = "spring")
public  abstract class UserMapper {

    public  abstract  Users toUser(UserRequestDTO userRequestDTO);

    public abstract UserResponseDTO toUserResponseDTO(Users users);



}

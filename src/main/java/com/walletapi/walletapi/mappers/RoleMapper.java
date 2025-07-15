package com.walletapi.walletapi.mappers;

import com.walletapi.walletapi.dto.RoleRequestDTO;
import com.walletapi.walletapi.dto.RoleResponseDTO;
import com.walletapi.walletapi.entities.Roles;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    Roles toRole(RoleRequestDTO dto);
    RoleResponseDTO toRoleResponseDTO(Roles roles);


}

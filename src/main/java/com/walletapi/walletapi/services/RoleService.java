package com.walletapi.walletapi.services;

import com.walletapi.walletapi.dto.RoleRequestDTO;
import com.walletapi.walletapi.dto.RoleResponseDTO;
import com.walletapi.walletapi.entities.Roles;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoleService {

    RoleResponseDTO createRole(RoleRequestDTO roleRequestDTO);


    List<RoleResponseDTO> getAllRoles();
    Optional<Roles> getRoleById(UUID id);
    Roles saveRole(Roles roles);
   void deleteRole(UUID id);
}

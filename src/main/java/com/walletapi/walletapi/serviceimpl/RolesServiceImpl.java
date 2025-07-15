package com.walletapi.walletapi.serviceimpl;

import com.sun.jdi.request.DuplicateRequestException;
import com.walletapi.walletapi.dto.RoleRequestDTO;
import com.walletapi.walletapi.dto.RoleResponseDTO;
import com.walletapi.walletapi.entities.Roles;
import com.walletapi.walletapi.mappers.RoleMapper;
import com.walletapi.walletapi.repository.RoleRepository;
import com.walletapi.walletapi.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class RolesServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public RoleResponseDTO createRole(RoleRequestDTO dto) {
        // Optional: check for duplicate role name
        Optional<Roles> existingRole = roleRepository.findByRoleName(dto.getRoleName());
        if (existingRole.isPresent()) {
            throw new DuplicateRequestException("Role with name '" + dto.getRoleName() + "' already exists.");
        }

        Roles role = roleMapper.toRole(dto);
        role.setCreatedBy("system");
        role.setCreatedOn(LocalDateTime.now());
        role.setModifiedBy("system");
        role.setModifiedOn(LocalDateTime.now());

        Roles saved = roleRepository.save(role);
        return roleMapper.toRoleResponseDTO(saved);
    }

    @Override
    public List<RoleResponseDTO> getAllRoles() {
        return roleRepository.findAll()
                .stream()
                .map(roleMapper::toRoleResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Roles> getRoleById(UUID id) {
        return roleRepository.findById(id);
    }

    @Override
    public Roles saveRole(Roles roles) {
        roles.setModifiedOn(LocalDateTime.now());
        return roleRepository.save(roles);
    }

    @Override
    public void deleteRole(UUID id) {
        roleRepository.deleteById(id);
    }
}

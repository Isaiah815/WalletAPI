package com.walletapi.walletapi.controller;

import com.walletapi.walletapi.dto.RoleRequestDTO;
import com.walletapi.walletapi.dto.RoleResponseDTO;
import com.walletapi.walletapi.entities.Roles;
import com.walletapi.walletapi.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/api/roles")
@RestController
@AllArgsConstructor


public class RoleController {
    private final RoleService roleService;

    @PostMapping
    public RoleResponseDTO createRole(@RequestBody RoleRequestDTO roleRequestDTO){
        return roleService.createRole(roleRequestDTO);
    }
    @GetMapping
    public ResponseEntity<List<RoleResponseDTO>> getAllRoles() {
        List<RoleResponseDTO> roles = roleService.getAllRoles();
        return ResponseEntity.ok(roles);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getRoleById(@PathVariable UUID id) {
        Optional<Roles> role = roleService.getRoleById(id);
        return role.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable UUID id) {
        roleService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }

}

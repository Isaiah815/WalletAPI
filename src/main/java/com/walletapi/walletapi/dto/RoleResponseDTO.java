package com.walletapi.walletapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class RoleResponseDTO {
    private UUID roleId;
    private String roleName;
}

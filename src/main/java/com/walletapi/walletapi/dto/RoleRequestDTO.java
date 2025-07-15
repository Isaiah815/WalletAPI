package com.walletapi.walletapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RoleRequestDTO {
    private String roleName;
    private String createdBy;
    private LocalDateTime createdOn;
}

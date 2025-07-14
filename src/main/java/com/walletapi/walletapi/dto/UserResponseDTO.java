package com.walletapi.walletapi.dto;

import com.walletapi.walletapi.entities.Wallet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private String roleId;

    private Wallet wallet;
}

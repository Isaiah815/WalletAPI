package com.walletapi.walletapi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor

@AllArgsConstructor
@Data
@Table(name = "roles")
@Entity
public class Roles {
    @Id
    @Column(name = "role_id")
    private UUID roleId;

    @Column(name = "role_name")
    private String roleName;
}

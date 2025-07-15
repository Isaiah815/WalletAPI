package com.walletapi.walletapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor

@AllArgsConstructor
@Data
@Table(name = "roles")
@Entity

public class Roles extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "role_id")
    private UUID roleId;

    @Column(name = "role_name")
    private String roleName;
}

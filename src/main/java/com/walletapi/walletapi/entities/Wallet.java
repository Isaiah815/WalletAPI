package com.walletapi.walletapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Table(name="wallet")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wallet extends  BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="wallet_id")
    private UUID walletId;

    @Column(name = "wallet_name")
    private String walletName;
    @OneToOne
    @JoinColumn(name="user_id")
    private Users users;
}

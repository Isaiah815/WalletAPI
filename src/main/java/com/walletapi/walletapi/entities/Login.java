package com.walletapi.walletapi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="login")
public class Login extends BaseEntity{
    @Id
    @Column(name = "username")
    private String userName;
    @Column(name = "password")
    private String password;
}

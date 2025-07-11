package com.walletapi.walletapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class Users  {
    @Id
    @Column(name="id")
    private UUID id;

    @Column(name = "username")
    private String userName;


    @Column(name ="first_name" )
    private String firstName;

    @Column(name ="second_name" )
    private String secondName;

    @Column(name = "email")
    private String userEmail;


    @ManyToOne
    @JoinColumn(name = "role_id")  // FK column in users table
    private Roles userRole;

}

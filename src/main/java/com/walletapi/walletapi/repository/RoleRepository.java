package com.walletapi.walletapi.repository;

import com.walletapi.walletapi.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository

public interface RoleRepository extends JpaRepository<Roles, UUID> {
    Optional<Roles> findByRoleName(String roleName);

}

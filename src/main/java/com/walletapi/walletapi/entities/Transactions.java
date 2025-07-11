package com.walletapi.walletapi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="transaction")



public class Transactions extends BaseEntity{
    @Id
    @Column(name = "transaction_id")
    private UUID transactionId;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name="external_ref")
    private String externalRef;

    @Column(name="transaction_ref")
    private  String transactionRef;


}

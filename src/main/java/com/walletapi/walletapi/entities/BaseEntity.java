package com.walletapi.walletapi.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity {

    @Column(name="created_by")
    public String createdBy;

    @Column(name="created_on")
    public LocalDateTime createdOn;

    @Column(name="modified_by")
    public String modifiedBy;

    @Column(name="modified_on")
    public LocalDateTime modifiedOn;

}

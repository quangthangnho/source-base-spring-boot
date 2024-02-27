package com.thanhquang.sourcebase.entities;

import com.thanhquang.sourcebase.entities.base.BaseEntityAudit;
import com.thanhquang.sourcebase.enums.user.UserRoles;
import com.thanhquang.sourcebase.enums.user.UserStatus;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Entity
@Getter
@Setter
@Table(name = "tbl_users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends BaseEntityAudit implements Serializable {

    @Column(name = "col_role", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRoles role;

    @Column(name = "col_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Column(name = "col_email", nullable = false, unique = true)
    private String email;

    @Column(name = "col_password", nullable = false)
    private String password;

    @Column(name = "col_fullName")
    private String fullName;

    @Column(name = "col_phoneNumber", unique = true)
    private String phoneNumber;
}

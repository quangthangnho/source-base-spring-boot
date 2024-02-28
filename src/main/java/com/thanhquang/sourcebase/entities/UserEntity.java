package com.thanhquang.sourcebase.entities;

import com.thanhquang.sourcebase.entities.base.BaseEntityAudit;
import com.thanhquang.sourcebase.enums.user.UserRoles;
import com.thanhquang.sourcebase.enums.user.UserStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
@Entity
@Getter
@Setter
@Table(name = "tbl_users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends BaseEntityAudit implements Serializable {

    @Column(name = "col_role", nullable = false, columnDefinition = "user_roles")
    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    private UserRoles role;

    @Column(name = "col_status", nullable = false, columnDefinition = "user_status")
    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    private UserStatus status;

    @Column(name = "col_email", nullable = false, unique = true)
    private String email;

    @Column(name = "col_password", nullable = false)
    private String password;

    @Column(name = "col_full_name")
    private String fullName;

    @Column(name = "col_phone_number", unique = true)
    private String phoneNumber;
}

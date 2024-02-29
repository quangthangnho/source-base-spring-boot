package com.thanhquang.sourcebase.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "tbl_users_roles")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleEntity implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "col_user_id")
    private UserEntity user;

    @Id
    @ManyToOne
    @JoinColumn(name = "col_role_id")
    private RoleEntity role;
}

package com.thanhquang.sourcebase.entities;

import com.thanhquang.sourcebase.entities.base.BaseEntity;
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
public class UserRoleEntity extends BaseEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "col_user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "col_role_id")
    private RoleEntity role;
}

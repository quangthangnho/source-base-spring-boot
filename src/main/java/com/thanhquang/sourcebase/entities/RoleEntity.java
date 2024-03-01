package com.thanhquang.sourcebase.entities;

import com.thanhquang.sourcebase.entities.base.BaseEntity;
import com.thanhquang.sourcebase.enums.user.Roles;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
@Entity
@Getter
@Setter
@Table(name = "tbl_roles")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity extends BaseEntity implements Serializable {

    @Column(name = "col_role_name", nullable = false, unique = true)
    private String roleName;

    @Column(name = "col_description")
    private String description;
}

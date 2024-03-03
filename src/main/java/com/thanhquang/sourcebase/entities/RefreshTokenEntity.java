package com.thanhquang.sourcebase.entities;

import com.thanhquang.sourcebase.entities.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@Table(name = "tbl_refresh_tokens")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenEntity extends BaseEntity implements Serializable {

    @Column(name = "col_token", nullable = false, unique = true)
    private String token;

    @Column(name = "col_expired_at", nullable = false)
    private OffsetDateTime expiredAt;

    @OneToOne
    @JoinColumn(name = "col_user_id", referencedColumnName = "id")
    private UserEntity user;
}

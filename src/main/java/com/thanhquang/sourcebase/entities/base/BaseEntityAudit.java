package com.thanhquang.sourcebase.entities.base;

import com.thanhquang.sourcebase.constant.CommonConstant;
import com.thanhquang.sourcebase.services.impl.UserDetailsImpl;
import com.thanhquang.sourcebase.utils.CommonUtils;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntityAudit extends BaseEntity implements Serializable {

    @Column(name = "createdBy")
    private String createdBy;

    @Column(name = "updatedBy")
    private String updatedBy;

    @Column(name = "deletedBy")
    private String deletedBy;

    @CreatedDate
    @Column(name = "createdAt", updatable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updatedAt", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime updatedAt;

    @Column(name = "deletedAt", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime deletedAt;

    @PrePersist
    public void onPrePersist() {
        String email = getEmailFromPrincipal();
        setCreatedAtAndCreatedBy(email);
        setUpdatedAtAndUpdatedBy(email);
    }

    @PreUpdate
    public void onPreUpdate() {
        String email = getEmailFromPrincipal();
        setUpdatedAtAndUpdatedBy(email);
    }

    private String getEmailFromPrincipal() {
        return CommonUtils.getPrincipal()
                .map(UserDetailsImpl::getUsername)
                .orElse(CommonConstant.DEFAULT_EMAIL);
    }

    private void setCreatedAtAndCreatedBy(String email) {
        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
        this.setCreatedAt(now);
        this.setCreatedBy(email);
    }

    private void setUpdatedAtAndUpdatedBy(String email) {
        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
        this.setUpdatedAt(now);
        this.setUpdatedBy(email);
    }
}

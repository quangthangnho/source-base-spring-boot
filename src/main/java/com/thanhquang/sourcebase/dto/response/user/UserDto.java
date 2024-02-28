package com.thanhquang.sourcebase.dto.response.user;

import com.thanhquang.sourcebase.enums.user.UserRoles;
import com.thanhquang.sourcebase.enums.user.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String createdBy;
    private String updatedBy;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private UserRoles role;
    private UserStatus status;
    private String email;
    private String fullName;
    private String phoneNumber;
}

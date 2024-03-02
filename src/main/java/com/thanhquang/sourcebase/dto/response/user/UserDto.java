package com.thanhquang.sourcebase.dto.response.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.thanhquang.sourcebase.enums.user.Roles;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    private Long id;
    private String createdBy;
    private String updatedBy;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private UserStatus status;
    private String email;
    private String fullName;
    private String phoneNumber;
}

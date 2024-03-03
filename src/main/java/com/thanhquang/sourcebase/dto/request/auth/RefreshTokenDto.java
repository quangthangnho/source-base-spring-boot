package com.thanhquang.sourcebase.dto.request.auth;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefreshTokenDto {

    @NotEmpty(message = "Refresh token is required")
    private String refreshToken;
}

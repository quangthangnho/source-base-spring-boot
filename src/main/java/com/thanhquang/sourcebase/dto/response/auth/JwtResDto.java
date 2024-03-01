package com.thanhquang.sourcebase.dto.response.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JwtResDto {

    private String accessToken;
    private String refreshToken;
}

package com.thanhquang.sourcebase.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
public class JwtDto {

    private String token;
    private OffsetDateTime expiredAt;
}

package com.thanhquang.sourcebase.utils;

import com.thanhquang.sourcebase.constant.CommonConstant;
import io.jsonwebtoken.Jwts;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

import static com.thanhquang.sourcebase.constant.CommonConstant.DEFAULT_TOKEN_EXPIRATION_TIME;
import static com.thanhquang.sourcebase.constant.CommonConstant.DEFAULT_TOKEN_ISSUER;

public class JwtUtils {
    public static String generateToken(String email) {
        OffsetDateTime nowOffsetDateTime = OffsetDateTime.now(ZoneOffset.UTC);
        Instant expirationInstant = nowOffsetDateTime.plusMinutes(DEFAULT_TOKEN_EXPIRATION_TIME).toInstant();

        return Jwts.builder()
                .id(UUID.randomUUID().toString())
                .issuer(DEFAULT_TOKEN_ISSUER)
                .subject(email)
                .issuedAt(Date.from(nowOffsetDateTime.toInstant()))
                .expiration(Date.from(expirationInstant))
                .signWith(CommonConstant.SECRET_KEY)
                .compact();
    }
}

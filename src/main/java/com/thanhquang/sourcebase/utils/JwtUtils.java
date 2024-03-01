package com.thanhquang.sourcebase.utils;

import com.thanhquang.sourcebase.constant.CommonConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import static com.thanhquang.sourcebase.constant.CommonConstant.DEFAULT_TOKEN_EXPIRATION_TIME;
import static com.thanhquang.sourcebase.constant.CommonConstant.DEFAULT_TOKEN_ISSUER;

@Slf4j
public class JwtUtils {

    private static final JwtParser JWT_PARSER = Jwts.parser()
            .verifyWith(CommonConstant.SECRET_KEY)
            .build();

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

    private static Optional<Claims> parseJwtToken(String jwtToken) {
        try {
            // Reusing the pre-built and configured JwtParser
            return Optional.of(JWT_PARSER.parseSignedClaims(jwtToken).getPayload());
        } catch (JwtException | IllegalArgumentException e) {
            log.error("JWT Exception occurred", e); // Consider logging the exception for better debugging
        }
        return Optional.empty();
    }

    public static boolean validateToken(String jwtToken) {
        return parseJwtToken(jwtToken).isPresent();
    }

    public static Optional<String> getEmailFromToken(String jwtToken) {
        return parseJwtToken(jwtToken)
                .map(Claims::getSubject);
    }

    public static Optional<String> getTokenFromRequest(HttpServletRequest request) {
        var authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (StringUtils.hasText(authHeader) && authHeader.startsWith(CommonConstant.DEFAULT_BEARER)) {
            return Optional.of(authHeader.substring(7));
        }
        return Optional.empty();
    }
}

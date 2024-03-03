package com.thanhquang.sourcebase.constant;

import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;

public class CommonConstant {

    public static final String DEFAULT_EMAIL = "Anonymous";
    public static final String DEFAULT_BEARER = "Bearer ";

    public static final SecretKey SECRET_KEY = Jwts.SIG.HS256.key().build();
    public static final String DEFAULT_TOKEN_ISSUER = "issuer_quang";

    public static final Integer DEFAULT_ACCESS_TOKEN_EXPIRATION_TIME = 1;  // MINUTES
    public static final Integer DEFAULT_REFRESH_TOKEN_EXPIRATION_TIME = 2;  // 2 days
}

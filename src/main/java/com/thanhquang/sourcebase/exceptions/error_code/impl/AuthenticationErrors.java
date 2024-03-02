package com.thanhquang.sourcebase.exceptions.error_code.impl;

import com.thanhquang.sourcebase.exceptions.error_code.ErrorCode;
import lombok.Getter;

@Getter
public enum AuthenticationErrors implements ErrorCode {

    USER_NOT_FOUND("Auth-001", "User not found"),
    ;

    private final String code;
    private final String message;

    AuthenticationErrors(String code, String message) {

        this.code = code;
        this.message = message;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String message() {
        return this.message;
    }
}

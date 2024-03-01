package com.thanhquang.sourcebase.dto.response.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiErrorResponse<T> extends ApiResponse<T> {

    private String errorCode;
    private String[] errorMessage;


    public ApiErrorResponse(String errorCode, String[] errorMessage) {
        super();
        super.setSuccess(false);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public static <T> ApiErrorResponse<T> fail(String errorCode, String[] errorMessage) {
        return new ApiErrorResponse<>(errorCode, errorMessage);
    }
}

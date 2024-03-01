package com.thanhquang.sourcebase.dto.response.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponse<T> {
    private boolean success;
    private T data;

    public ApiResponse(T data) {
        this.success = true;
        this.data = data;
    }

    public static <T> ApiResponse<T> success() {
        return new ApiResponse<>(null);
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(data);
    }
}

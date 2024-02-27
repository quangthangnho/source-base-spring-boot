package com.thanhquang.sourcebase.services;

import com.thanhquang.sourcebase.dto.response.auth.RegisterDto;

public interface AuthService {

    void register(RegisterDto registerDto);
}

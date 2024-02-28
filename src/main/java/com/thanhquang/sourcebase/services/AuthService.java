package com.thanhquang.sourcebase.services;

import com.thanhquang.sourcebase.dto.request.auth.LoginDto;
import com.thanhquang.sourcebase.dto.request.auth.RegisterDto;
import com.thanhquang.sourcebase.dto.response.user.UserDto;

public interface AuthService {

    UserDto register(RegisterDto registerDto);

    UserDto login(LoginDto loginDto);
}

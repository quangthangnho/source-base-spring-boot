package com.thanhquang.sourcebase.services.impl;

import com.thanhquang.sourcebase.dto.response.auth.RegisterDto;
import com.thanhquang.sourcebase.entities.UserEntity;
import com.thanhquang.sourcebase.enums.user.UserRoles;
import com.thanhquang.sourcebase.enums.user.UserStatus;
import com.thanhquang.sourcebase.mapper.AuthMapper;
import com.thanhquang.sourcebase.repositories.UserRepository;
import com.thanhquang.sourcebase.services.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(RegisterDto registerDto) {
        UserEntity user = AuthMapper.INSTANCE.toUserEntity(registerDto);
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setStatus(UserStatus.ACTIVE);
        user.setRole(UserRoles.USER);
        userRepository.save(user);
    }
}

package com.thanhquang.sourcebase.services.impl;

import com.thanhquang.sourcebase.dto.request.auth.LoginDto;
import com.thanhquang.sourcebase.dto.request.auth.RegisterDto;
import com.thanhquang.sourcebase.dto.response.user.UserDto;
import com.thanhquang.sourcebase.entities.UserEntity;
import com.thanhquang.sourcebase.enums.user.Roles;
import com.thanhquang.sourcebase.enums.user.UserStatus;
import com.thanhquang.sourcebase.mapper.AuthMapper;
import com.thanhquang.sourcebase.mapper.UserMapper;
import com.thanhquang.sourcebase.repositories.UserRepository;
import com.thanhquang.sourcebase.repositories.UserRoleRepository;
import com.thanhquang.sourcebase.services.AuthService;
import com.thanhquang.sourcebase.utils.JwtUtils;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationProvider authenticationProvider;

    public AuthServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder, AuthenticationProvider authenticationProvider) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationProvider = authenticationProvider;
    }

    @Override
    public UserDto register(RegisterDto registerDto) {
        if (userRepository.existsByEmailAndDeletedAtIsNull(registerDto.getEmail())) {
            // TODO: need handle exception here
        }
        if (registerDto.getPhoneNumber() != null && userRepository.existsByPhoneNumberAndDeletedAtIsNull(registerDto.getPhoneNumber())) {
            // TODO: need handle exception here
        }

        UserEntity user = AuthMapper.INSTANCE.toUserEntity(registerDto);
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setStatus(UserStatus.ACTIVE);
        user.setr(Roles.USER);
        return UserMapper.INSTANCE.toUserDto(userRepository.save(user));
    }

    @Override
    public UserDto login(LoginDto loginDto) {
        authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
        String token = JwtUtils.generateToken(loginDto.getEmail());
        return null;
    }
}

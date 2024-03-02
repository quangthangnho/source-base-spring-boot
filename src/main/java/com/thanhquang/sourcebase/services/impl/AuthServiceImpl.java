package com.thanhquang.sourcebase.services.impl;

import com.thanhquang.sourcebase.dto.request.auth.LoginDto;
import com.thanhquang.sourcebase.dto.request.auth.RegisterDto;
import com.thanhquang.sourcebase.dto.response.auth.JwtResDto;
import com.thanhquang.sourcebase.dto.response.user.UserDto;
import com.thanhquang.sourcebase.entities.RoleEntity;
import com.thanhquang.sourcebase.entities.UserEntity;
import com.thanhquang.sourcebase.entities.UserRoleEntity;
import com.thanhquang.sourcebase.enums.user.Roles;
import com.thanhquang.sourcebase.enums.user.UserStatus;
import com.thanhquang.sourcebase.exceptions.BadRequestException;
import com.thanhquang.sourcebase.exceptions.error_code.impl.AuthenticationErrors;
import com.thanhquang.sourcebase.exceptions.error_code.impl.UserErrors;
import com.thanhquang.sourcebase.mapper.AuthMapper;
import com.thanhquang.sourcebase.mapper.UserMapper;
import com.thanhquang.sourcebase.repositories.RoleRepository;
import com.thanhquang.sourcebase.repositories.UserRepository;
import com.thanhquang.sourcebase.services.AuthService;
import com.thanhquang.sourcebase.utils.JwtUtils;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationProvider authenticationProvider;

    public AuthServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, AuthenticationProvider authenticationProvider) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationProvider = authenticationProvider;
    }

    @Transactional
    @Override
    public UserDto register(RegisterDto registerDto) throws BadRequestException {
        if (userRepository.existsByEmailAndDeletedAtIsNull(registerDto.getEmail())) {
            throw new BadRequestException(UserErrors.EMAIL_EXISTS);
        }
        if (registerDto.getPhoneNumber() != null && userRepository.existsByPhoneNumberAndDeletedAtIsNull(registerDto.getPhoneNumber())) {
            throw new BadRequestException(UserErrors.PHONE_EXISTS);
        }
        UserEntity user = AuthMapper.INSTANCE.toUserEntity(registerDto);
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setStatus(UserStatus.ACTIVE);

        UserRoleEntity userRole = UserRoleEntity.builder()
                .user(user)
                .role(getDefaultRole())
                .build();
        user.setUserRoles(Set.of(userRole));
        return UserMapper.INSTANCE.toUserDto(userRepository.save(user));
    }

    @Override
    public JwtResDto login(LoginDto loginDto) throws BadRequestException {
        authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
        UserEntity user = userRepository.findByEmailAndDeletedAtIsNull(loginDto.getEmail())
                .orElseThrow(() -> new BadRequestException(AuthenticationErrors.USER_NOT_FOUND));

        if (user.getStatus() == UserStatus.DEACTIVATED) {
            throw new BadRequestException(UserErrors.USER_DEACTIVATED);
        }
        String accessToken = JwtUtils.generateToken(loginDto.getEmail());
        return new JwtResDto(accessToken, "");
    }

    private RoleEntity getDefaultRole() {
        return roleRepository.findByRoleName(Roles.USER.name()).orElseThrow(
                // TDO: NEED throw EXCEPTION
                () -> new RuntimeException("Default role not found"));
    }
}

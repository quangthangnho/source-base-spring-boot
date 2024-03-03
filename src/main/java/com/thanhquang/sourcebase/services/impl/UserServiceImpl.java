package com.thanhquang.sourcebase.services.impl;

import com.thanhquang.sourcebase.entities.UserEntity;
import com.thanhquang.sourcebase.exceptions.BadRequestException;
import com.thanhquang.sourcebase.exceptions.error_code.impl.AuthenticationErrors;
import com.thanhquang.sourcebase.repositories.UserRepository;
import com.thanhquang.sourcebase.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity findByEmailAndDeletedAtIsNull(String email) throws BadRequestException {
        return userRepository.findByEmailAndDeletedAtIsNull(email)
                .orElseThrow(() -> new BadRequestException(AuthenticationErrors.USER_NOT_FOUND));
    }
}

package com.thanhquang.sourcebase.utils;

import com.thanhquang.sourcebase.services.impl.user_detail.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class CommonUtils {

    public static Optional<UserDetailsImpl> getPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetailsImpl) {
            return Optional.of((UserDetailsImpl) authentication.getPrincipal());
        }
        return Optional.empty();
    }
}

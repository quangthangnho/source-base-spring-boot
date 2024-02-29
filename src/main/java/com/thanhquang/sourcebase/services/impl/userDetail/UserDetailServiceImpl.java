package com.thanhquang.sourcebase.services.impl.userDetail;

import com.thanhquang.sourcebase.entities.UserEntity;
import com.thanhquang.sourcebase.entities.UserRoleEntity;
import com.thanhquang.sourcebase.repositories.UserRepository;
import com.thanhquang.sourcebase.repositories.UserRoleRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    public UserDetailServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmailAndDeletedAtIsNull(email).orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " + email));
        List<UserRoleEntity> roles = userRoleRepository.findAllByUser(user);
        return new UserDetailsImpl(user, roles);
    }
}

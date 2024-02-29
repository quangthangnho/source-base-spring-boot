package com.thanhquang.sourcebase.repositories;

import com.thanhquang.sourcebase.entities.UserEntity;
import com.thanhquang.sourcebase.entities.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

    List<UserRoleEntity> findAllByUser(UserEntity user);
}

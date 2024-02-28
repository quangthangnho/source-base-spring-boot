package com.thanhquang.sourcebase.mapper;

import com.thanhquang.sourcebase.dto.response.user.UserDto;
import com.thanhquang.sourcebase.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    UserDto toUserDto(UserEntity userEntity);
}

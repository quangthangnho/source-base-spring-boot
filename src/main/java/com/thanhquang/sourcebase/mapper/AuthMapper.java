package com.thanhquang.sourcebase.mapper;

import com.thanhquang.sourcebase.dto.request.auth.RegisterDto;
import com.thanhquang.sourcebase.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthMapper {

    AuthMapper INSTANCE = Mappers.getMapper( AuthMapper.class );

    UserEntity toUserEntity(RegisterDto registerDto);
}

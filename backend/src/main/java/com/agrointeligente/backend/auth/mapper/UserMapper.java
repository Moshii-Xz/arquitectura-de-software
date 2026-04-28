package com.agrointeligente.backend.auth.mapper;

import com.agrointeligente.backend.auth.dto.UserDto;
import com.agrointeligente.backend.auth.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {

    @Mapping(target = "roleName", source = "role.name")
    UserDto toDto(User user);

    @Mapping(target = "role", ignore = true)
    User toEntity(UserDto dto);
}

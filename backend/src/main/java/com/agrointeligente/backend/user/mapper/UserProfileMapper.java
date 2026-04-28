package com.agrointeligente.backend.user.mapper;

import com.agrointeligente.backend.user.dto.UserProfileDto;
import com.agrointeligente.backend.user.entity.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserProfileMapper {

    UserProfileDto toDto(UserProfile userProfile);

    UserProfile toEntity(UserProfileDto dto);
}

package com.agrointeligente.backend.user.mapper;

import com.agrointeligente.backend.user.dto.NotificationPreferenceDto;
import com.agrointeligente.backend.user.entity.NotificationPreference;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface NotificationPreferenceMapper {

    NotificationPreferenceDto toDto(NotificationPreference notificationPreference);

    NotificationPreference toEntity(NotificationPreferenceDto dto);
}

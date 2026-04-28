package com.agrointeligente.backend.user.service;

import com.agrointeligente.backend.user.dto.UserLocationDto;
import com.agrointeligente.backend.user.dto.UserProfileDto;

public interface UserProfileService {

    UserProfileDto getUserProfile(Long userId);

    UserProfileDto updateUserProfile(Long userId, UserProfileDto dto);

    void deleteUserProfile(Long userId);

    UserLocationDto getLastUserLocation(Long userId);

    UserLocationDto createUserLocation(Long userId, UserLocationDto dto);

    void updateUserLocation(Long locationId, UserLocationDto dto);
}

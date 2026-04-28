package com.agrointeligente.backend.user.service.impl;

import com.agrointeligente.backend.shared.exception.BusinessException;
import com.agrointeligente.backend.user.dto.UserLocationDto;
import com.agrointeligente.backend.user.dto.UserProfileDto;
import com.agrointeligente.backend.user.entity.UserLocation;
import com.agrointeligente.backend.user.entity.UserProfile;
import com.agrointeligente.backend.user.mapper.UserLocationMapper;
import com.agrointeligente.backend.user.mapper.UserProfileMapper;
import com.agrointeligente.backend.user.repository.UserLocationRepository;
import com.agrointeligente.backend.user.repository.UserProfileRepository;
import com.agrointeligente.backend.user.service.UserProfileService;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final UserLocationRepository userLocationRepository;
    private final UserProfileMapper userProfileMapper;
    private final UserLocationMapper userLocationMapper;

    @Override
    @Transactional(readOnly = true)
    public UserProfileDto getUserProfile(Long userId) {
        var profile = userProfileRepository.findByUserId(userId)
            .orElseThrow(() -> new BusinessException("Perfil de usuario no encontrado"));
        return userProfileMapper.toDto(profile);
    }

    @Override
    public UserProfileDto updateUserProfile(Long userId, UserProfileDto dto) {
        var profile = userProfileRepository.findByUserId(userId)
            .orElseThrow(() -> new BusinessException("Perfil de usuario no encontrado"));

        if (dto.getFirstName() != null) {
            profile.setFirstName(dto.getFirstName());
        }
        if (dto.getLastName() != null) {
            profile.setLastName(dto.getLastName());
        }
        if (dto.getPhoneNumber() != null) {
            profile.setPhoneNumber(dto.getPhoneNumber());
        }
        if (dto.getMunicipality() != null) {
            profile.setMunicipality(dto.getMunicipality());
        }
        if (dto.getFarmName() != null) {
            profile.setFarmName(dto.getFarmName());
        }
        if (dto.getLanguage() != null) {
            profile.setLanguage(dto.getLanguage());
        }
        if (dto.getPhotoUrl() != null) {
            profile.setPhotoUrl(dto.getPhotoUrl());
        }

        profile.setUpdatedAt(LocalDateTime.now());
        var updated = userProfileRepository.save(profile);

        log.info("Perfil de usuario actualizado: {}", userId);
        return userProfileMapper.toDto(updated);
    }

    @Override
    public void deleteUserProfile(Long userId) {
        var profile = userProfileRepository.findByUserId(userId)
            .orElseThrow(() -> new BusinessException("Perfil de usuario no encontrado"));
        userProfileRepository.delete(profile);
        log.info("Perfil de usuario eliminado: {}", userId);
    }

    @Override
    @Transactional(readOnly = true)
    public UserLocationDto getLastUserLocation(Long userId) {
        var location = userLocationRepository.findFirstByUserIdOrderByCreatedAtDesc(userId)
            .orElseThrow(() -> new BusinessException("Ubicacion de usuario no encontrada"));
        return userLocationMapper.toDto(location);
    }

    @Override
    public UserLocationDto createUserLocation(Long userId, UserLocationDto dto) {
        var location = UserLocation.builder()
            .user(new com.agrointeligente.backend.auth.entity.User().toBuilder().id(userId).build())
            .latitude(dto.getLatitude() != null ? new java.math.BigDecimal(dto.getLatitude()) : null)
            .longitude(dto.getLongitude() != null ? new java.math.BigDecimal(dto.getLongitude()) : null)
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .build();

        var saved = userLocationRepository.save(location);
        log.info("Ubicacion de usuario creada: {} para usuario: {}", saved.getId(), userId);
        return userLocationMapper.toDto(saved);
    }

    @Override
    public void updateUserLocation(Long locationId, UserLocationDto dto) {
        var location = userLocationRepository.findById(locationId)
            .orElseThrow(() -> new BusinessException("Ubicacion no encontrada"));

        if (dto.getLatitude() != null) {
            location.setLatitude(new java.math.BigDecimal(dto.getLatitude()));
        }
        if (dto.getLongitude() != null) {
            location.setLongitude(new java.math.BigDecimal(dto.getLongitude()));
        }

        location.setUpdatedAt(LocalDateTime.now());
        userLocationRepository.save(location);

        log.info("Ubicacion actualizada: {}", locationId);
    }
}

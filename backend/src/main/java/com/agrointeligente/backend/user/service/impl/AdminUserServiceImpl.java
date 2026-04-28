package com.agrointeligente.backend.user.service.impl;

import com.agrointeligente.backend.auth.dto.UserDto;
import com.agrointeligente.backend.auth.entity.User;
import com.agrointeligente.backend.auth.mapper.UserMapper;
import com.agrointeligente.backend.auth.repository.RoleRepository;
import com.agrointeligente.backend.auth.repository.UserRepository;
import com.agrointeligente.backend.shared.exception.BusinessException;
import com.agrointeligente.backend.user.service.AdminUserService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class AdminUserServiceImpl implements AdminUserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional(readOnly = true)
    public Page<UserDto> getAllUsers(Pageable pageable) {
        var page = userRepository.findAll(pageable);
        var content = page.getContent().stream()
            .map(userMapper::toDto)
            .collect(Collectors.toList());
        return new PageImpl<>(content, pageable, page.getTotalElements());
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDto> getUsersByRole(String roleName) {
        var role = roleRepository.findByName(roleName)
            .orElseThrow(() -> new BusinessException("Rol no encontrado: " + roleName));

        return userRepository.findAll().stream()
            .filter(user -> user.getRole().getId().equals(role.getId()))
            .map(userMapper::toDto)
            .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getUserById(Long userId) {
        var user = userRepository.findById(userId)
            .orElseThrow(() -> new BusinessException("Usuario no encontrado"));
        return userMapper.toDto(user);
    }

    @Override
    public void activateUser(Long userId) {
        var user = userRepository.findById(userId)
            .orElseThrow(() -> new BusinessException("Usuario no encontrado"));

        if ("ACTIVE".equals(user.getStatus())) {
            throw new BusinessException("Usuario ya esta activo");
        }

        user.setStatus("ACTIVE");
        user.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user);

        log.info("Usuario activado: {}", userId);
    }

    @Override
    public void deactivateUser(Long userId) {
        var user = userRepository.findById(userId)
            .orElseThrow(() -> new BusinessException("Usuario no encontrado"));

        if ("INACTIVE".equals(user.getStatus())) {
            throw new BusinessException("Usuario ya esta inactivo");
        }

        user.setStatus("INACTIVE");
        user.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user);

        log.info("Usuario desactivado: {}", userId);
    }

    @Override
    public void changeUserRole(Long userId, String newRoleName) {
        var user = userRepository.findById(userId)
            .orElseThrow(() -> new BusinessException("Usuario no encontrado"));

        var newRole = roleRepository.findByName(newRoleName)
            .orElseThrow(() -> new BusinessException("Rol no encontrado: " + newRoleName));

        user.setRole(newRole);
        user.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user);

        log.info("Rol de usuario {} cambiado a {}", userId, newRoleName);
    }

    @Override
    public void deleteUser(Long userId) {
        var user = userRepository.findById(userId)
            .orElseThrow(() -> new BusinessException("Usuario no encontrado"));

        userRepository.delete(user);
        log.info("Usuario eliminado: {}", userId);
    }
}

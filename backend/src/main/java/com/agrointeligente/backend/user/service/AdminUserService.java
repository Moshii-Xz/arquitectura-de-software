package com.agrointeligente.backend.user.service;

import com.agrointeligente.backend.auth.dto.UserDto;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdminUserService {

    Page<UserDto> getAllUsers(Pageable pageable);

    List<UserDto> getUsersByRole(String roleName);

    UserDto getUserById(Long userId);

    void activateUser(Long userId);

    void deactivateUser(Long userId);

    void changeUserRole(Long userId, String newRoleName);

    void deleteUser(Long userId);
}

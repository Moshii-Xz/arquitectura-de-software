package com.agrointeligente.backend.user.controller;

import com.agrointeligente.backend.auth.dto.UserDto;
import com.agrointeligente.backend.shared.api.ApiResponse;
import com.agrointeligente.backend.user.service.AdminUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/users")
@RequiredArgsConstructor
@Tag(name = "Administracion de Usuarios", description = "Endpoints para administracion de usuarios (solo ADMIN)")
@SecurityRequirement(name = "bearerAuth")
public class AdminUserController {

    private final AdminUserService adminUserService;

    @GetMapping
    @Operation(summary = "Listar todos los usuarios", description = "Obtiene lista paginada de todos los usuarios")
    public ResponseEntity<ApiResponse<Page<UserDto>>> getAllUsers(Pageable pageable) {
        var users = adminUserService.getAllUsers(pageable);
        return ResponseEntity.ok(ApiResponse.ok(users));
    }

    @GetMapping("/by-role")
    public ResponseEntity<ApiResponse<?>> getUsersByRole(
        @RequestParam @NotBlank String roleName) {
        var users = adminUserService.getUsersByRole(roleName);
        return ResponseEntity.ok(ApiResponse.ok(users));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserDto>> getUserById(
        @PathVariable Long userId) {
        var user = adminUserService.getUserById(userId);
        return ResponseEntity.ok(ApiResponse.ok(user));
    }

    @PutMapping("/{userId}/activate")
    public ResponseEntity<ApiResponse<String>> activateUser(
        @PathVariable Long userId) {
        adminUserService.activateUser(userId);
        return ResponseEntity.ok(ApiResponse.ok("Usuario activado"));
    }

    @PutMapping("/{userId}/deactivate")
    public ResponseEntity<ApiResponse<String>> deactivateUser(
        @PathVariable Long userId) {
        adminUserService.deactivateUser(userId);
        return ResponseEntity.ok(ApiResponse.ok("Usuario desactivado"));
    }

    @PutMapping("/{userId}/role")
    public ResponseEntity<ApiResponse<String>> changeUserRole(
        @PathVariable Long userId,
        @RequestBody ChangeRoleRequest request) {
        adminUserService.changeUserRole(userId, request.getRoleName());
        return ResponseEntity.ok(ApiResponse.ok("Rol de usuario cambio exitosamente"));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse<String>> deleteUser(
        @PathVariable Long userId) {
        adminUserService.deleteUser(userId);
        return ResponseEntity.ok(ApiResponse.ok("Usuario eliminado"));
    }

    public static class ChangeRoleRequest {
        private String roleName;

        public String getRoleName() {
            return roleName;
        }

        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }
    }
}

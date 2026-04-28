package com.agrointeligente.backend.user.controller;

import com.agrointeligente.backend.shared.api.ApiResponse;
import com.agrointeligente.backend.user.dto.UserLocationDto;
import com.agrointeligente.backend.user.dto.UserProfileDto;
import com.agrointeligente.backend.user.service.UserProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users/profile")
@RequiredArgsConstructor
@Tag(name = "Perfil de Usuario", description = "Endpoints para gestion del perfil y ubicacion del usuario")
public class UserProfileController {

    private final UserProfileService userProfileService;

    @GetMapping("/{userId}")
    @Operation(summary = "Obtener perfil de usuario", description = "Obtiene el perfil completo del usuario")
    public ResponseEntity<ApiResponse<UserProfileDto>> getUserProfile(
        @PathVariable Long userId) {
        var profile = userProfileService.getUserProfile(userId);
        return ResponseEntity.ok(ApiResponse.ok(profile));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserProfileDto>> updateUserProfile(
        @PathVariable Long userId,
        @Valid @RequestBody UserProfileDto dto) {
        var updated = userProfileService.updateUserProfile(userId, dto);
        return ResponseEntity.ok(ApiResponse.ok("Perfil actualizado", updated));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse<String>> deleteUserProfile(
        @PathVariable Long userId) {
        userProfileService.deleteUserProfile(userId);
        return ResponseEntity.ok(ApiResponse.ok("Perfil eliminado"));
    }

    @GetMapping("/{userId}/location")
    public ResponseEntity<ApiResponse<UserLocationDto>> getLastUserLocation(
        @PathVariable Long userId) {
        var location = userProfileService.getLastUserLocation(userId);
        return ResponseEntity.ok(ApiResponse.ok(location));
    }

    @PostMapping("/{userId}/location")
    public ResponseEntity<ApiResponse<UserLocationDto>> createUserLocation(
        @PathVariable Long userId,
        @Valid @RequestBody UserLocationDto dto) {
        var location = userProfileService.createUserLocation(userId, dto);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(ApiResponse.ok("Ubicacion creada", location));
    }

    @PutMapping("/location/{locationId}")
    public ResponseEntity<ApiResponse<String>> updateUserLocation(
        @PathVariable Long locationId,
        @Valid @RequestBody UserLocationDto dto) {
        userProfileService.updateUserLocation(locationId, dto);
        return ResponseEntity.ok(ApiResponse.ok("Ubicacion actualizada"));
    }
}

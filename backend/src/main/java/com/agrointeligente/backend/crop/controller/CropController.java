package com.agrointeligente.backend.crop.controller;

import com.agrointeligente.backend.crop.dto.*;
import com.agrointeligente.backend.crop.entity.CropStatus;
import com.agrointeligente.backend.crop.service.CropService;
import com.agrointeligente.backend.shared.api.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cultivos")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Gestión de Cultivos", description = "Endpoints para gestión de cultivos, fotos y observaciones")
@SecurityRequirement(name = "bearerAuth")
public class CropController {
    
    private final CropService cropService;
    
    private Long getUserIdFromAuth(Authentication auth) {
        return Long.parseLong(auth.getName());
    }
    
    /**
     * RF-15: Crear un nuevo cultivo
     */
    @PostMapping
    @Operation(summary = "Crear nuevo cultivo",
            description = "RF-15: Crea un nuevo cultivo para el usuario autenticado")
    public ResponseEntity<ApiResponse<CropResponse>> createCrop(
            @Valid @RequestBody CropRequest request,
            Authentication auth) {
        log.info("POST /api/v1/cultivos - Crear cultivo");
        Long userId = getUserIdFromAuth(auth);
        CropResponse response = cropService.createCrop(request, userId);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(response, "Cultivo creado exitosamente"));
    }
    
    /**
     * RF-16: Obtener listado de cultivos activos (con RF-23: filtros y búsqueda)
     */
    @GetMapping
    @Operation(summary = "Listar cultivos activos con filtros",
            description = "RF-16 y RF-23: Obtiene cultivos activos del usuario con posibilidad de filtrar por nombre, tipo y estado")
    public ResponseEntity<ApiResponse<Page<CropResponse>>> listCrops(
            @Parameter(description = "Nombre de cultivo a buscar")
            @RequestParam(required = false) String nombre,
            
            @Parameter(description = "Tipo de cultivo a filtrar")
            @RequestParam(required = false) String tipo,
            
            @Parameter(description = "Estado del cultivo a filtrar")
            @RequestParam(required = false) CropStatus status,
            
            Pageable pageable,
            Authentication auth) {
        log.info("GET /api/v1/cultivos - Listar cultivos con filtros");
        Long userId = getUserIdFromAuth(auth);
        
        Page<CropResponse> response;
        if (nombre != null || tipo != null || status != null) {
            response = cropService.searchCrops(userId, nombre, tipo, status, pageable);
        } else {
            response = cropService.getActiveCropsForUser(userId, pageable);
        }
        
        return ResponseEntity.ok(ApiResponse.success(response, "Cultivos obtenidos"));
    }
    
    /**
     * RF-17: Obtener detalle completo de un cultivo
     */
    @GetMapping("/{id}")
    @Operation(summary = "Obtener detalle de cultivo",
            description = "RF-17: Retorna la información completa del cultivo incluyendo observaciones y fotos")
    public ResponseEntity<ApiResponse<CropDetailResponse>> getCropDetail(
            @Parameter(description = "ID del cultivo")
            @PathVariable Long id,
            Authentication auth) {
        log.info("GET /api/v1/cultivos/{} - Obtener detalle", id);
        Long userId = getUserIdFromAuth(auth);
        CropDetailResponse response = cropService.getCropDetail(id, userId);
        return ResponseEntity.ok(ApiResponse.success(response, "Detalle del cultivo"));
    }
    
    /**
     * RF-18: Editar cultivo no finalizado
     */
    @PutMapping("/{id}")
    @Operation(summary = "Editar cultivo",
            description = "RF-18: Actualiza un cultivo (solo si no está finalizado)")
    public ResponseEntity<ApiResponse<CropResponse>> updateCrop(
            @Parameter(description = "ID del cultivo")
            @PathVariable Long id,
            @Valid @RequestBody CropRequest request,
            Authentication auth) {
        log.info("PUT /api/v1/cultivos/{} - Editar cultivo", id);
        Long userId = getUserIdFromAuth(auth);
        CropResponse response = cropService.updateCrop(id, request, userId);
        return ResponseEntity.ok(ApiResponse.success(response, "Cultivo actualizado"));
    }
    
    /**
     * RF-19: Actualizar estado de cultivo con timestamp
     */
    @PatchMapping("/{id}/estado")
    @Operation(summary = "Cambiar estado de cultivo",
            description = "RF-19: Actualiza el estado del cultivo registrando el cambio con timestamp")
    public ResponseEntity<ApiResponse<CropResponse>> updateCropStatus(
            @Parameter(description = "ID del cultivo")
            @PathVariable Long id,
            
            @Parameter(description = "Nuevo estado del cultivo")
            @RequestParam CropStatus nuevoEstado,
            Authentication auth) {
        log.info("PATCH /api/v1/cultivos/{}/estado - Actualizar estado a {}", id, nuevoEstado);
        Long userId = getUserIdFromAuth(auth);
        CropResponse response = cropService.updateCropStatus(id, nuevoEstado, userId);
        return ResponseEntity.ok(ApiResponse.success(response, "Estado actualizado"));
    }
    
    /**
     * RF-20: Eliminar cultivo con confirmación (soft delete)
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar cultivo",
            description = "RF-20: Realiza eliminación lógica del cultivo conservando el historial")
    public ResponseEntity<ApiResponse<Void>> deleteCrop(
            @Parameter(description = "ID del cultivo")
            @PathVariable Long id,
            Authentication auth) {
        log.info("DELETE /api/v1/cultivos/{} - Eliminar cultivo", id);
        Long userId = getUserIdFromAuth(auth);
        cropService.deleteCrop(id, userId);
        return ResponseEntity.ok(ApiResponse.success(null, "Cultivo eliminado"));
    }
    
    /**
     * RF-21: Adjuntar foto a cultivo
     */
    @PostMapping("/{id}/fotos")
    @Operation(summary = "Adjuntar foto al cultivo",
            description = "RF-21: Añade una foto asociada al cultivo")
    public ResponseEntity<ApiResponse<CropPhotoDto>> attachPhoto(
            @Parameter(description = "ID del cultivo")
            @PathVariable Long id,
            
            @Parameter(description = "Ruta del archivo de foto")
            @RequestParam String filePath,
            
            @Parameter(description = "Nombre original del archivo")
            @RequestParam String nombreOriginal,
            
            @Parameter(description = "Tamaño en bytes")
            @RequestParam(required = false) Long tamanioBytes,
            
            @Parameter(description = "Tipo de contenido (ej: image/jpeg)")
            @RequestParam(required = false) String tipoContenido,
            Authentication auth) {
        log.info("POST /api/v1/cultivos/{}/fotos - Adjuntar foto", id);
        Long userId = getUserIdFromAuth(auth);
        CropPhotoDto response = cropService.attachPhoto(id, filePath, nombreOriginal, 
                                                         tamanioBytes, tipoContenido, userId);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(response, "Foto adjuntada"));
    }
    
    /**
     * RF-22: Registrar observación de cultivo
     */
    @PostMapping("/{id}/observaciones")
    @Operation(summary = "Registrar observación",
            description = "RF-22: Registra una observación asociada al cultivo")
    public ResponseEntity<ApiResponse<CropObservationDto>> addObservation(
            @Parameter(description = "ID del cultivo")
            @PathVariable Long id,
            @Valid @RequestBody CropObservationDto observationDto,
            Authentication auth) {
        log.info("POST /api/v1/cultivos/{}/observaciones - Registrar observación", id);
        Long userId = getUserIdFromAuth(auth);
        CropObservationDto response = cropService.addObservation(id, observationDto, userId);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(response, "Observación registrada"));
    }
    
    /**
     * Obtener fotos de un cultivo
     */
    @GetMapping("/{id}/fotos")
    @Operation(summary = "Obtener fotos del cultivo",
            description = "Retorna todas las fotos asociadas al cultivo")
    public ResponseEntity<ApiResponse<Page<CropPhotoDto>>> getCropPhotos(
            @Parameter(description = "ID del cultivo")
            @PathVariable Long id,
            Pageable pageable,
            Authentication auth) {
        log.info("GET /api/v1/cultivos/{}/fotos - Obtener fotos", id);
        Long userId = getUserIdFromAuth(auth);
        Page<CropPhotoDto> response = cropService.getCropPhotos(id, userId, pageable);
        return ResponseEntity.ok(ApiResponse.success(response, "Fotos del cultivo"));
    }
    
    /**
     * Obtener observaciones de un cultivo
     */
    @GetMapping("/{id}/observaciones")
    @Operation(summary = "Obtener observaciones del cultivo",
            description = "Retorna todas las observaciones asociadas al cultivo")
    public ResponseEntity<ApiResponse<Page<CropObservationDto>>> getCropObservations(
            @Parameter(description = "ID del cultivo")
            @PathVariable Long id,
            Pageable pageable,
            Authentication auth) {
        log.info("GET /api/v1/cultivos/{}/observaciones - Obtener observaciones", id);
        Long userId = getUserIdFromAuth(auth);
        Page<CropObservationDto> response = cropService.getCropObservations(id, userId, pageable);
        return ResponseEntity.ok(ApiResponse.success(response, "Observaciones del cultivo"));
    }
}

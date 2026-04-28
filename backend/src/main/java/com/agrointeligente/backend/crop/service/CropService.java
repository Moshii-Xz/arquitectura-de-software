package com.agrointeligente.backend.crop.service;

import com.agrointeligente.backend.crop.dto.*;
import com.agrointeligente.backend.crop.entity.CropStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CropService {
    
    /**
     * RF-15: Crear un nuevo cultivo para el usuario autenticado
     */
    CropResponse createCrop(CropRequest request, Long userId);
    
    /**
     * RF-16: Obtener listado de cultivos activos del usuario con paginación
     */
    Page<CropResponse> getActiveCropsForUser(Long userId, Pageable pageable);
    
    /**
     * RF-17: Obtener detalle completo de un cultivo
     */
    CropDetailResponse getCropDetail(Long cropId, Long userId);
    
    /**
     * RF-18: Editar cultivo solo si no está finalizado
     */
    CropResponse updateCrop(Long cropId, CropRequest request, Long userId);
    
    /**
     * RF-19: Actualizar estado de cultivo con registro de cambio
     */
    CropResponse updateCropStatus(Long cropId, CropStatus newStatus, Long userId);
    
    /**
     * RF-20: Eliminar cultivo (soft delete)
     */
    void deleteCrop(Long cropId, Long userId);
    
    /**
     * RF-21: Adjuntar foto a cultivo
     */
    CropPhotoDto attachPhoto(Long cropId, String filePath, String nombreOriginal, 
                            Long tamanioBytes, String tipoContenido, Long userId);
    
    /**
     * RF-22: Registrar observación de cultivo
     */
    CropObservationDto addObservation(Long cropId, CropObservationDto observationDto, Long userId);
    
    /**
     * RF-23: Buscar cultivos con filtros avanzados
     */
    Page<CropResponse> searchCrops(Long userId, String nombre, String tipo, 
                                   CropStatus status, Pageable pageable);
    
    /**
     * Obtener todas las fotos de un cultivo
     */
    Page<CropPhotoDto> getCropPhotos(Long cropId, Long userId, Pageable pageable);
    
    /**
     * Obtener todas las observaciones de un cultivo
     */
    Page<CropObservationDto> getCropObservations(Long cropId, Long userId, Pageable pageable);
}

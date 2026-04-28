package com.agrointeligente.backend.crop.service;

import com.agrointeligente.backend.crop.dto.*;
import com.agrointeligente.backend.crop.entity.Crop;
import com.agrointeligente.backend.crop.entity.CropObservation;
import com.agrointeligente.backend.crop.entity.CropPhoto;
import com.agrointeligente.backend.crop.entity.CropStatus;
import com.agrointeligente.backend.crop.mapper.CropMapper;
import com.agrointeligente.backend.crop.mapper.CropObservationMapper;
import com.agrointeligente.backend.crop.repository.CropObservationRepository;
import com.agrointeligente.backend.crop.repository.CropPhotoRepository;
import com.agrointeligente.backend.crop.repository.CropRepository;
import com.agrointeligente.backend.shared.exception.ResourceNotFoundException;
import com.agrointeligente.backend.shared.exception.ValidationException;
import com.agrointeligente.backend.user.entity.User;
import com.agrointeligente.backend.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CropServiceImpl implements CropService {
    
    private final CropRepository cropRepository;
    private final CropObservationRepository observationRepository;
    private final CropPhotoRepository photoRepository;
    private final UserRepository userRepository;
    private final CropMapper cropMapper;
    private final CropObservationMapper observationMapper;
    
    @Override
    public CropResponse createCrop(CropRequest request, Long userId) {
        log.info("Creando cultivo para usuario: {}", userId);
        
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        
        Crop crop = cropMapper.toCropFromRequest(request);
        crop.setUser(user);
        crop.setStatus(CropStatus.PLANTADO);
        
        Crop saved = cropRepository.save(crop);
        log.info("Cultivo creado con ID: {}", saved.getId());
        
        return cropMapper.toCropResponse(saved);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Page<CropResponse> getActiveCropsForUser(Long userId, Pageable pageable) {
        log.info("Obteniendo cultivos activos para usuario: {}", userId);
        
        return cropRepository.findByUserIdAndDeletedAtIsNullOrderByFechaPlantacionDesc(userId, pageable)
                .map(cropMapper::toCropResponse);
    }
    
    @Override
    @Transactional(readOnly = true)
    public CropDetailResponse getCropDetail(Long cropId, Long userId) {
        log.info("Obteniendo detalle de cultivo: {}", cropId);
        
        Crop crop = cropRepository.findByIdAndDeletedAtIsNull(cropId)
                .orElseThrow(() -> new ResourceNotFoundException("Cultivo no encontrado"));
        
        if (!crop.getUser().getId().equals(userId)) {
            throw new ValidationException("No tienes permiso para acceder a este cultivo");
        }
        
        CropDetailResponse response = cropMapper.toCropDetailResponse(crop);
        response.setObservaciones(
                observationRepository.findByCropIdOrderByCreatedAtDesc(cropId)
                        .stream()
                        .map(observationMapper::toDto)
                        .collect(Collectors.toList())
        );
        response.setFotos(
                photoRepository.findByCropIdOrderByCreatedAtDesc(cropId)
                        .stream()
                        .map(photo -> CropPhotoDto.builder()
                                .id(photo.getId())
                                .path(photo.getPath())
                                .nombreOriginal(photo.getNombreOriginal())
                                .tamanioBytes(photo.getTamanioBytes())
                                .tipoContenido(photo.getTipoContenido())
                                .createdAt(photo.getCreatedAt())
                                .build())
                        .collect(Collectors.toList())
        );
        
        return response;
    }
    
    @Override
    public CropResponse updateCrop(Long cropId, CropRequest request, Long userId) {
        log.info("Actualizando cultivo: {}", cropId);
        
        Crop crop = cropRepository.findByIdAndDeletedAtIsNull(cropId)
                .orElseThrow(() -> new ResourceNotFoundException("Cultivo no encontrado"));
        
        if (!crop.getUser().getId().equals(userId)) {
            throw new ValidationException("No tienes permiso para editar este cultivo");
        }
        
        if (crop.isFinalized()) {
            throw new ValidationException("No se puede editar un cultivo finalizado");
        }
        
        cropMapper.updateCropFromRequest(request, crop);
        Crop updated = cropRepository.save(crop);
        
        log.info("Cultivo actualizado: {}", cropId);
        return cropMapper.toCropResponse(updated);
    }
    
    @Override
    public CropResponse updateCropStatus(Long cropId, CropStatus newStatus, Long userId) {
        log.info("Actualizando estado de cultivo {} a {}", cropId, newStatus);
        
        Crop crop = cropRepository.findByIdAndDeletedAtIsNull(cropId)
                .orElseThrow(() -> new ResourceNotFoundException("Cultivo no encontrado"));
        
        if (!crop.getUser().getId().equals(userId)) {
            throw new ValidationException("No tienes permiso para modificar este cultivo");
        }
        
        CropStatus previousStatus = crop.getStatus();
        crop.setStatus(newStatus);
        Crop updated = cropRepository.save(crop);
        
        log.info("Estado actualizado: {} -> {}", previousStatus, newStatus);
        return cropMapper.toCropResponse(updated);
    }
    
    @Override
    public void deleteCrop(Long cropId, Long userId) {
        log.info("Eliminando cultivo: {}", cropId);
        
        Crop crop = cropRepository.findByIdAndDeletedAtIsNull(cropId)
                .orElseThrow(() -> new ResourceNotFoundException("Cultivo no encontrado"));
        
        if (!crop.getUser().getId().equals(userId)) {
            throw new ValidationException("No tienes permiso para eliminar este cultivo");
        }
        
        crop.setDeletedAt(LocalDateTime.now());
        cropRepository.save(crop);
        
        log.info("Cultivo eliminado (soft delete): {}", cropId);
    }
    
    @Override
    public CropPhotoDto attachPhoto(Long cropId, String filePath, String nombreOriginal,
                                    Long tamanioBytes, String tipoContenido, Long userId) {
        log.info("Adjuntando foto a cultivo: {}", cropId);
        
        Crop crop = cropRepository.findByIdAndDeletedAtIsNull(cropId)
                .orElseThrow(() -> new ResourceNotFoundException("Cultivo no encontrado"));
        
        if (!crop.getUser().getId().equals(userId)) {
            throw new ValidationException("No tienes permiso para adjuntar fotos a este cultivo");
        }
        
        CropPhoto photo = CropPhoto.builder()
                .crop(crop)
                .path(filePath)
                .nombreOriginal(nombreOriginal)
                .tamanioBytes(tamanioBytes)
                .tipoContenido(tipoContenido)
                .build();
        
        CropPhoto saved = photoRepository.save(photo);
        log.info("Foto adjuntada con ID: {}", saved.getId());
        
        return CropPhotoDto.builder()
                .id(saved.getId())
                .path(saved.getPath())
                .nombreOriginal(saved.getNombreOriginal())
                .tamanioBytes(saved.getTamanioBytes())
                .tipoContenido(saved.getTipoContenido())
                .createdAt(saved.getCreatedAt())
                .build();
    }
    
    @Override
    public CropObservationDto addObservation(Long cropId, CropObservationDto observationDto, Long userId) {
        log.info("Añadiendo observación a cultivo: {}", cropId);
        
        Crop crop = cropRepository.findByIdAndDeletedAtIsNull(cropId)
                .orElseThrow(() -> new ResourceNotFoundException("Cultivo no encontrado"));
        
        if (!crop.getUser().getId().equals(userId)) {
            throw new ValidationException("No tienes permiso para añadir observaciones a este cultivo");
        }
        
        User usuario = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        
        CropObservation observation = CropObservation.builder()
                .crop(crop)
                .usuario(usuario)
                .texto(observationDto.getTexto())
                .tipoObservacion(observationDto.getTipoObservacion())
                .build();
        
        CropObservation saved = observationRepository.save(observation);
        log.info("Observación añadida con ID: {}", saved.getId());
        
        return observationMapper.toDto(saved);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Page<CropResponse> searchCrops(Long userId, String nombre, String tipo,
                                          CropStatus status, Pageable pageable) {
        log.info("Buscando cultivos para usuario: {} con criterios - nombre: {}, tipo: {}, status: {}",
                userId, nombre, tipo, status);
        
        return cropRepository.searchCrops(userId, nombre, tipo, status, pageable)
                .map(cropMapper::toCropResponse);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Page<CropPhotoDto> getCropPhotos(Long cropId, Long userId, Pageable pageable) {
        log.info("Obteniendo fotos de cultivo: {}", cropId);
        
        Crop crop = cropRepository.findByIdAndDeletedAtIsNull(cropId)
                .orElseThrow(() -> new ResourceNotFoundException("Cultivo no encontrado"));
        
        if (!crop.getUser().getId().equals(userId)) {
            throw new ValidationException("No tienes permiso para acceder a este cultivo");
        }
        
        return photoRepository.findByCropIdOrderByCreatedAtDesc(cropId, pageable)
                .map(photo -> CropPhotoDto.builder()
                        .id(photo.getId())
                        .path(photo.getPath())
                        .nombreOriginal(photo.getNombreOriginal())
                        .tamanioBytes(photo.getTamanioBytes())
                        .tipoContenido(photo.getTipoContenido())
                        .createdAt(photo.getCreatedAt())
                        .build());
    }
    
    @Override
    @Transactional(readOnly = true)
    public Page<CropObservationDto> getCropObservations(Long cropId, Long userId, Pageable pageable) {
        log.info("Obteniendo observaciones de cultivo: {}", cropId);
        
        Crop crop = cropRepository.findByIdAndDeletedAtIsNull(cropId)
                .orElseThrow(() -> new ResourceNotFoundException("Cultivo no encontrado"));
        
        if (!crop.getUser().getId().equals(userId)) {
            throw new ValidationException("No tienes permiso para acceder a este cultivo");
        }
        
        return observationRepository.findByCropIdOrderByCreatedAtDesc(cropId, pageable)
                .map(observationMapper::toDto);
    }
}

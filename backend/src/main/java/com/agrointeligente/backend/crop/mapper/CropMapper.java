package com.agrointeligente.backend.crop.mapper;

import com.agrointeligente.backend.crop.dto.CropDetailResponse;
import com.agrointeligente.backend.crop.dto.CropRequest;
import com.agrointeligente.backend.crop.dto.CropResponse;
import com.agrointeligente.backend.crop.entity.Crop;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CropMapper {
    
    /**
     * Mapea Crop a CropResponse
     */
    @Mapping(target = "usuarioId", source = "user.id")
    @Mapping(target = "usuarioNombre", source = "user.username")
    CropResponse toCropResponse(Crop crop);
    
    /**
     * Mapea Crop a CropDetailResponse (incluye relaciones)
     */
    @Mapping(target = "usuarioId", source = "user.id")
    @Mapping(target = "usuarioNombre", source = "user.username")
    @Mapping(target = "observaciones", source = "observations")
    @Mapping(target = "fotos", source = "photos")
    CropDetailResponse toCropDetailResponse(Crop crop);
    
    /**
     * Crea un nuevo Crop desde CropRequest
     */
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "observations", ignore = true)
    @Mapping(target = "photos", ignore = true)
    Crop toCropFromRequest(CropRequest request);
    
    /**
     * Actualiza un Crop existente desde CropRequest
     */
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "observations", ignore = true)
    @Mapping(target = "photos", ignore = true)
    void updateCropFromRequest(CropRequest request, @MappingTarget Crop crop);
}

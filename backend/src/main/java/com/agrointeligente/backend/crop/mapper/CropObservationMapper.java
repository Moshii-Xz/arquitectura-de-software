package com.agrointeligente.backend.crop.mapper;

import com.agrointeligente.backend.crop.dto.CropObservationDto;
import com.agrointeligente.backend.crop.entity.CropObservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CropObservationMapper {
    
    /**
     * Mapea CropObservation a CropObservationDto
     */
    @Mapping(target = "usuarioId", source = "usuario.id")
    @Mapping(target = "usuarioNombre", source = "usuario.username")
    CropObservationDto toDto(CropObservation observation);
    
    /**
     * Crea un nuevo CropObservation desde CropObservationDto
     */
    @Mapping(target = "crop", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    CropObservation toEntity(CropObservationDto dto);
}

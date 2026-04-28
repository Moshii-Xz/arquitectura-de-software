package com.agrointeligente.backend.crop.dto;

import com.agrointeligente.backend.crop.entity.CropStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CropResponse {
    
    private Long id;
    private String nombre;
    private String tipo;
    private BigDecimal hectareas;
    private CropStatus status;
    private LocalDate fechaPlantacion;
    private LocalDate fechaInicioCosecha;
    private LocalDate fechaFinCosecha;
    private BigDecimal ubicacionLat;
    private BigDecimal ubicacionLng;
    private String descripcion;
    private Long usuarioId;
    private String usuarioNombre;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

package com.agrointeligente.backend.crop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CropObservationDto {
    
    private Long id;
    
    @NotBlank(message = "El texto de la observación es requerido")
    @Size(min = 3, max = 2000, message = "El texto debe tener entre 3 y 2000 caracteres")
    private String texto;
    
    private String tipoObservacion;
    private Long usuarioId;
    private String usuarioNombre;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

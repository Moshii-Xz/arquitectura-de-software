package com.agrointeligente.backend.crop.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CropRequest {
    
    @NotBlank(message = "El nombre del cultivo es requerido")
    @Size(min = 3, max = 255, message = "El nombre debe tener entre 3 y 255 caracteres")
    private String nombre;
    
    @NotBlank(message = "El tipo de cultivo es requerido")
    @Size(min = 2, max = 100, message = "El tipo debe tener entre 2 y 100 caracteres")
    private String tipo;
    
    @NotNull(message = "Las hectáreas son requeridas")
    @DecimalMin(value = "0.01", message = "Las hectáreas deben ser mayor a 0")
    @DecimalMax(value = "99999.99", message = "Las hectáreas no pueden exceder 99999.99")
    private BigDecimal hectareas;
    
    @NotNull(message = "La fecha de plantación es requerida")
    @PastOrPresent(message = "La fecha de plantación no puede ser futura")
    private LocalDate fechaPlantacion;
    
    private LocalDate fechaInicioCosecha;
    
    private LocalDate fechaFinCosecha;
    
    @DecimalMin(value = "-90", message = "Latitud inválida")
    @DecimalMax(value = "90", message = "Latitud inválida")
    private BigDecimal ubicacionLat;
    
    @DecimalMin(value = "-180", message = "Longitud inválida")
    @DecimalMax(value = "180", message = "Longitud inválida")
    private BigDecimal ubicacionLng;
    
    @Size(max = 1000, message = "La descripción no puede exceder 1000 caracteres")
    private String descripcion;
}

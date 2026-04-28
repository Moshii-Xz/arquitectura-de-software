package com.agrointeligente.backend.crop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CropPhotoDto {
    
    private Long id;
    private String path;
    private String nombreOriginal;
    private Long tamanioBytes;
    private String tipoContenido;
    private LocalDateTime createdAt;
}

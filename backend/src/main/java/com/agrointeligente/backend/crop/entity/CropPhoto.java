package com.agrointeligente.backend.crop.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "crop_photos", indexes = {
        @Index(name = "idx_photos_crop_id", columnList = "crop_id"),
        @Index(name = "idx_photos_created_at", columnList = "created_at")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CropPhoto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crop_id", nullable = false)
    private Crop crop;
    
    @Column(nullable = false, length = 500)
    private String path;
    
    @Column(name = "nombre_original", length = 255)
    private String nombreOriginal;
    
    @Column(name = "tamanio_bytes")
    private Long tamanioBytes;
    
    @Column(name = "tipo_contenido", length = 50)
    private String tipoContenido;
    
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}

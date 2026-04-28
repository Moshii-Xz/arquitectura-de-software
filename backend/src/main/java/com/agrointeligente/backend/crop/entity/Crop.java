package com.agrointeligente.backend.crop.entity;

import com.agrointeligente.backend.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "crops", indexes = {
        @Index(name = "idx_crops_user_id", columnList = "user_id"),
        @Index(name = "idx_crops_status", columnList = "status"),
        @Index(name = "idx_crops_deleted_at", columnList = "deleted_at")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Crop {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @Column(nullable = false, length = 255)
    private String nombre;
    
    @Column(nullable = false, length = 100)
    private String tipo;
    
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal hectareas;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CropStatus status;
    
    @Column(name = "ubicacion_lat", precision = 10, scale = 8)
    private BigDecimal ubicacionLat;
    
    @Column(name = "ubicacion_lng", precision = 11, scale = 8)
    private BigDecimal ubicacionLng;
    
    @Column(name = "fecha_plantacion", nullable = false)
    private LocalDate fechaPlantacion;
    
    @Column(name = "fecha_inicio_cosecha")
    private LocalDate fechaInicioCosecha;
    
    @Column(name = "fecha_fin_cosecha")
    private LocalDate fechaFinCosecha;
    
    @Column(columnDefinition = "TEXT")
    private String descripcion;
    
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
    
    @OneToMany(mappedBy = "crop", cascade = CascadeType.ALL, orphanRemoval = true)
    private java.util.List<CropObservation> observations = new java.util.ArrayList<>();
    
    @OneToMany(mappedBy = "crop", cascade = CascadeType.ALL, orphanRemoval = true)
    private java.util.List<CropPhoto> photos = new java.util.ArrayList<>();
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
    
    public boolean isActive() {
        return deletedAt == null;
    }
    
    public boolean isFinalized() {
        return status == CropStatus.FINALIZADO;
    }
}

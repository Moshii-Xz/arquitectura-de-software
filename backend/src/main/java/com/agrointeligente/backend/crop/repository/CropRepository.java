package com.agrointeligente.backend.crop.repository;

import com.agrointeligente.backend.crop.entity.Crop;
import com.agrointeligente.backend.crop.entity.CropStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.ListCrudRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CropRepository extends ListCrudRepository<Crop, Long> {
    
    /**
     * Encuentra todos los cultivos de un usuario que no están eliminados
     */
    Page<Crop> findByUserIdAndDeletedAtIsNullOrderByFechaPlantacionDesc(Long userId, Pageable pageable);
    
    /**
     * Encuentra cultivos activos de un usuario por estado
     */
    Page<Crop> findByUserIdAndStatusAndDeletedAtIsNullOrderByFechaPlantacionDesc(
            Long userId, CropStatus status, Pageable pageable);
    
    /**
     * Encuentra cultivos activos por tipo
     */
    Page<Crop> findByUserIdAndTipoContainingIgnoreCaseAndDeletedAtIsNullOrderByFechaPlantacionDesc(
            Long userId, String tipo, Pageable pageable);
    
    /**
     * Busca cultivos por nombre (parcial) del usuario
     */
    Page<Crop> findByUserIdAndNombreContainingIgnoreCaseAndDeletedAtIsNullOrderByFechaPlantacionDesc(
            Long userId, String nombre, Pageable pageable);
    
    /**
     * Busca cultivos activos en rango de fechas
     */
    @Query("SELECT c FROM Crop c WHERE c.user.id = :userId AND c.deletedAt IS NULL " +
            "AND c.fechaPlantacion BETWEEN :startDate AND :endDate " +
            "ORDER BY c.fechaPlantacion DESC")
    Page<Crop> findByUserIdAndFechaPlantacionBetweenAndDeletedAtIsNull(
            @Param("userId") Long userId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            Pageable pageable);
    
    /**
     * Búsqueda avanzada con múltiples criterios
     */
    @Query("SELECT c FROM Crop c WHERE c.user.id = :userId AND c.deletedAt IS NULL " +
            "AND (:nombre IS NULL OR LOWER(c.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))) " +
            "AND (:tipo IS NULL OR LOWER(c.tipo) LIKE LOWER(CONCAT('%', :tipo, '%'))) " +
            "AND (:status IS NULL OR c.status = :status) " +
            "ORDER BY c.fechaPlantacion DESC")
    Page<Crop> searchCrops(
            @Param("userId") Long userId,
            @Param("nombre") String nombre,
            @Param("tipo") String tipo,
            @Param("status") CropStatus status,
            Pageable pageable);
    
    /**
     * Encuentra un cultivo por ID verificando que no esté eliminado
     */
    Optional<Crop> findByIdAndDeletedAtIsNull(Long id);
    
    /**
     * Verifica si un cultivo pertenece al usuario
     */
    boolean existsByIdAndUserIdAndDeletedAtIsNull(Long id, Long userId);
    
    /**
     * Obtiene cultivos finalizados del usuario
     */
    List<Crop> findByUserIdAndStatusAndDeletedAtIsNull(Long userId, CropStatus status);
}

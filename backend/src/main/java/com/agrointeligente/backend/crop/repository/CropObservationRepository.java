package com.agrointeligente.backend.crop.repository;

import com.agrointeligente.backend.crop.entity.CropObservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.ListCrudRepository;
import java.util.List;

public interface CropObservationRepository extends ListCrudRepository<CropObservation, Long> {
    
    /**
     * Encuentra todas las observaciones de un cultivo ordenadas por fecha
     */
    Page<CropObservation> findByCropIdOrderByCreatedAtDesc(Long cropId, Pageable pageable);
    
    /**
     * Obtiene todas las observaciones de un cultivo sin paginación
     */
    List<CropObservation> findByCropIdOrderByCreatedAtDesc(Long cropId);
    
    /**
     * Obtiene observaciones por tipo de observación
     */
    List<CropObservation> findByCropIdAndTipoObservacionOrderByCreatedAtDesc(Long cropId, String tipoObservacion);
    
    /**
     * Cuenta observaciones de un cultivo
     */
    long countByCropId(Long cropId);
}

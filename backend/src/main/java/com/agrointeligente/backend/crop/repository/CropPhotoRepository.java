package com.agrointeligente.backend.crop.repository;

import com.agrointeligente.backend.crop.entity.CropPhoto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.ListCrudRepository;
import java.util.List;

public interface CropPhotoRepository extends ListCrudRepository<CropPhoto, Long> {
    
    /**
     * Encuentra todas las fotos de un cultivo ordenadas por fecha descendente
     */
    Page<CropPhoto> findByCropIdOrderByCreatedAtDesc(Long cropId, Pageable pageable);
    
    /**
     * Obtiene todas las fotos de un cultivo sin paginación
     */
    List<CropPhoto> findByCropIdOrderByCreatedAtDesc(Long cropId);
    
    /**
     * Cuenta fotos de un cultivo
     */
    long countByCropId(Long cropId);
    
    /**
     * Elimina todas las fotos de un cultivo
     */
    void deleteByCropId(Long cropId);
}

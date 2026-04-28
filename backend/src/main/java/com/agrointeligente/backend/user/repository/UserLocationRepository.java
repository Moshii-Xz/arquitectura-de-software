package com.agrointeligente.backend.user.repository;

import com.agrointeligente.backend.user.entity.UserLocation;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLocationRepository extends JpaRepository<UserLocation, Long> {

    List<UserLocation> findByUserId(Long userId);

    Optional<UserLocation> findFirstByUserIdOrderByCreatedAtDesc(Long userId);
}

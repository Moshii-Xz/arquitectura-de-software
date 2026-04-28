package com.agrointeligente.backend.auth.repository;

import com.agrointeligente.backend.auth.entity.PasswordReset;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordResetRepository extends JpaRepository<PasswordReset, Long> {

    Optional<PasswordReset> findByResetToken(String resetToken);

    Optional<PasswordReset> findByUserIdAndUsedAtIsNull(Long userId);
}

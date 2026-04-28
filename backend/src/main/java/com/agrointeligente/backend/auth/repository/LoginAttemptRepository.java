package com.agrointeligente.backend.auth.repository;

import com.agrointeligente.backend.auth.entity.LoginAttempt;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginAttemptRepository extends JpaRepository<LoginAttempt, Long> {

    List<LoginAttempt> findByEmailAndAttemptedAtAfter(String email, LocalDateTime afterTime);

    List<LoginAttempt> findByUserIdAndAttemptedAtAfter(Long userId, LocalDateTime afterTime);
}

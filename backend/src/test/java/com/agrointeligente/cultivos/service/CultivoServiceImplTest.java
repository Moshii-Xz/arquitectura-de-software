package com.agrointeligente.cultivos.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import com.agrointeligente.cultivos.dto.CultivoUpdateRequest;
import com.agrointeligente.cultivos.entity.CultivoEntity;
import com.agrointeligente.cultivos.repository.CultivoRepository;
import com.agrointeligente.entity.UserEntity;
import com.agrointeligente.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CultivoServiceImplTest {

    @Mock
    private CultivoRepository cultivoRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private CultivoServiceImpl cultivoService;

    @Test
    void deleteMarksCultivoAsArchived() {
        CultivoEntity cultivo = new CultivoEntity();
        cultivo.setId(UUID.randomUUID());
        cultivo.setEstado("ACTIVO");
        cultivo.setUsuario(new UserEntity());

        when(cultivoRepository.findById(cultivo.getId())).thenReturn(Optional.of(cultivo));
        when(cultivoRepository.save(cultivo)).thenReturn(cultivo);

        cultivoService.delete(cultivo.getId());

        assertThat(cultivo.getEstado()).isEqualTo("ARCHIVADO");
        assertThat(cultivo.getDeletedAt()).isNotNull();
        verify(cultivoRepository).save(cultivo);
    }
}
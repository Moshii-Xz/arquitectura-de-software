package com.agrointeligente.insumos.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import com.agrointeligente.cultivos.entity.CultivoEntity;
import com.agrointeligente.cultivos.repository.CultivoRepository;
import com.agrointeligente.insumos.dto.AplicacionInsumoCreateRequest;
import com.agrointeligente.insumos.entity.AplicacionInsumoEntity;
import com.agrointeligente.insumos.entity.InsumoEntity;
import com.agrointeligente.insumos.repository.AplicacionInsumoRepository;
import com.agrointeligente.insumos.repository.InsumoRepository;
import com.agrointeligente.entity.UserEntity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class InsumoServiceImplTest {

    @Mock
    private InsumoRepository insumoRepository;

    @Mock
    private AplicacionInsumoRepository aplicacionInsumoRepository;

    @Mock
    private CultivoRepository cultivoRepository;

    @InjectMocks
    private InsumoServiceImpl insumoService;

    @Test
    void createAplicacionLinksCultivoAndInsumo() {
        UUID cultivoId = UUID.randomUUID();
        UUID insumoId = UUID.randomUUID();

        UserEntity usuario = new UserEntity();
        usuario.setId(UUID.randomUUID());

        CultivoEntity cultivo = new CultivoEntity();
        cultivo.setId(cultivoId);
        cultivo.setUsuario(usuario);

        InsumoEntity insumo = new InsumoEntity();
        insumo.setId(insumoId);
        insumo.setNombre("Fertilizante NPK");
        insumo.setUnidad("kg");

        when(cultivoRepository.findById(cultivoId)).thenReturn(Optional.of(cultivo));
        when(insumoRepository.findById(insumoId)).thenReturn(Optional.of(insumo));
        when(aplicacionInsumoRepository.save(any(AplicacionInsumoEntity.class))).thenAnswer(invocation -> {
            AplicacionInsumoEntity entity = invocation.getArgument(0);
            entity.setId(UUID.randomUUID());
            entity.setCreatedAt(LocalDateTime.now());
            entity.setUpdatedAt(LocalDateTime.now());
            return entity;
        });

        var response = insumoService.createAplicacion(cultivoId,
                new AplicacionInsumoCreateRequest(insumoId, new BigDecimal("10.5"), new BigDecimal("25.00"), "kg",
                        LocalDateTime.now(), "Aplicación de prueba"));

        assertThat(response.cultivoId()).isEqualTo(cultivoId);
        assertThat(response.insumoId()).isEqualTo(insumoId);
        assertThat(response.cantidad()).isEqualByComparingTo("10.5");
    }
}
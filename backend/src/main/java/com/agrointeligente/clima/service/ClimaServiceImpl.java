package com.agrointeligente.clima.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.agrointeligente.clima.dto.ClimaResponse;
import com.agrointeligente.cultivos.entity.CultivoEntity;
import com.agrointeligente.cultivos.repository.CultivoRepository;
import com.agrointeligente.exception.NotFoundException;
import com.agrointeligente.usuario.entity.PerfilEntity;
import com.agrointeligente.usuario.repository.PerfilRepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ClimaServiceImpl implements ClimaService {

    private final CultivoRepository cultivoRepository;
    private final PerfilRepository perfilRepository;
    private final RestClient restClient;

    public ClimaServiceImpl(CultivoRepository cultivoRepository, PerfilRepository perfilRepository,
            @Value("${app.climate.base-url}") String climateBaseUrl) {
        this.cultivoRepository = cultivoRepository;
        this.perfilRepository = perfilRepository;
        this.restClient = RestClient.builder().baseUrl(climateBaseUrl).build();
    }

    @Override
    public ClimaResponse consultarClimaPorCoordenadas(Double latitud, Double longitud) {
        if (latitud == null || longitud == null) {
            return simularClima("Sin coordenadas");
        }
        try {
            @SuppressWarnings("unchecked")
            var respuesta = restClient.get()
                    .uri(uriBuilder -> uriBuilder.queryParam("latitude", latitud).queryParam("longitude", longitud)
                            .queryParam("current", "temperature_2m,relative_humidity_2m,precipitation,wind_speed_10m")
                            .queryParam("daily", "temperature_2m_max,temperature_2m_min,precipitation_sum").build())
                    .retrieve()
                    .body(java.util.Map.class);
            return construirDesdeRespuesta(respuesta);
        } catch (Exception exception) {
            return simularClima("Integración externa no disponible");
        }
    }

    @Override
    public ClimaResponse consultarClimaDeCultivo(UUID cultivoId) {
        CultivoEntity cultivo = cultivoRepository.findById(cultivoId)
                .orElseThrow(() -> new NotFoundException("Cultivo no encontrado: " + cultivoId));
        PerfilEntity perfil = perfilRepository.findByUsuarioId(cultivo.getUsuario().getId()).orElse(null);
        if (perfil == null || perfil.getLatitud() == null || perfil.getLongitud() == null) {
            return simularClima("Cultivo sin coordenadas asociadas");
        }
        return consultarClimaPorCoordenadas(perfil.getLatitud(), perfil.getLongitud());
    }

    private ClimaResponse construirDesdeRespuesta(java.util.Map<String, Object> respuesta) {
        if (respuesta == null) {
            return simularClima("Respuesta vacía");
        }
        Object currentObj = respuesta.get("current");
        if (!(currentObj instanceof java.util.Map<?, ?> current)) {
            return simularClima("Estructura de clima no reconocida");
        }
        Double temperatura = toDouble(current.get("temperature_2m"));
        Double humedad = toDouble(current.get("relative_humidity_2m"));
        Double precipitacion = toDouble(current.get("precipitation"));
        Double viento = toDouble(current.get("wind_speed_10m"));
        return new ClimaResponse(temperatura, humedad, precipitacion, viento,
                "Datos climáticos actuales obtenidos desde API externa", List.of(), LocalDateTime.now());
    }

    private ClimaResponse simularClima(String motivo) {
        return new ClimaResponse(31.5, 78.0, 2.4, 12.0,
                "Datos simulados: " + motivo,
                List.of("Hoy con lluvias leves", "Mañana parcialmente nublado", "Siguiente día estable"),
                LocalDateTime.now());
    }

    private Double toDouble(Object value) {
        if (value instanceof Number number) {
            return number.doubleValue();
        }
        return null;
    }
}
package com.agrointeligente.reportes.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.agrointeligente.entity.UserEntity;
import com.agrointeligente.exception.NotFoundException;
import com.agrointeligente.reportes.dto.ReporteCreateRequest;
import com.agrointeligente.reportes.dto.ReporteResponse;
import com.agrointeligente.reportes.entity.ReporteEntity;
import com.agrointeligente.reportes.repository.ReporteRepository;
import com.agrointeligente.repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReporteServiceImpl implements ReporteService {

    private final ReporteRepository reporteRepository;
    private final UserRepository userRepository;

    public ReporteServiceImpl(ReporteRepository reporteRepository, UserRepository userRepository) {
        this.reporteRepository = reporteRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReporteResponse> findAll() {
        return reporteRepository.findByDeletedAtIsNull().stream().map(this::toResponse).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ReporteResponse findById(UUID id) {
        return toResponse(getReporte(id));
    }

    @Override
    public ReporteResponse create(ReporteCreateRequest request) {
        UserEntity usuario = userRepository.findById(request.usuarioId())
                .orElseThrow(() -> new NotFoundException("Usuario no encontrado: " + request.usuarioId()));

        ReporteEntity reporte = new ReporteEntity();
        reporte.setUsuario(usuario);
        reporte.setTipo(request.tipo());
        reporte.setPeriodoInicio(request.periodoInicio());
        reporte.setPeriodoFin(request.periodoFin());
        reporte.setFormato(request.formato() == null ? "JSON" : request.formato());
        reporte.setUrlArchivo(request.urlArchivo());
        reporte.setResumen(request.resumen());
        reporte.setEstado("LISTO");
        return toResponse(reporteRepository.save(reporte));
    }

    @Override
    public void delete(UUID id) {
        ReporteEntity reporte = getReporte(id);
        reporte.setDeletedAt(LocalDateTime.now());
        reporteRepository.save(reporte);
    }

    private ReporteEntity getReporte(UUID id) {
        return reporteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Reporte no encontrado: " + id));
    }

    private ReporteResponse toResponse(ReporteEntity reporte) {
        return new ReporteResponse(reporte.getId(), reporte.getUsuario().getId(), reporte.getTipo(),
                reporte.getPeriodoInicio(), reporte.getPeriodoFin(), reporte.getFormato(), reporte.getEstado(),
                reporte.getUrlArchivo(), reporte.getResumen(), reporte.getCreatedAt(), reporte.getUpdatedAt());
    }
}
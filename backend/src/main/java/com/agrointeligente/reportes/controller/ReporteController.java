package com.agrointeligente.reportes.controller;

import java.util.List;
import java.util.UUID;

import com.agrointeligente.reportes.dto.ReporteCreateRequest;
import com.agrointeligente.reportes.dto.ReporteResponse;
import com.agrointeligente.reportes.service.ReporteService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    private final ReporteService reporteService;

    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    @GetMapping
    public List<ReporteResponse> listar() {
        return reporteService.findAll();
    }

    @GetMapping("/{id}")
    public ReporteResponse obtener(@PathVariable UUID id) {
        return reporteService.findById(id);
    }

    @PostMapping
    public ResponseEntity<ReporteResponse> crear(@Valid @RequestBody ReporteCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reporteService.create(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable UUID id) {
        reporteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
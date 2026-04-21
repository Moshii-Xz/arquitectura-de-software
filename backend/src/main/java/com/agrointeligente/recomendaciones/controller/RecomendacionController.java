package com.agrointeligente.recomendaciones.controller;

import java.util.List;
import java.util.UUID;

import com.agrointeligente.recomendaciones.dto.RecomendacionCreateRequest;
import com.agrointeligente.recomendaciones.dto.RecomendacionResponse;
import com.agrointeligente.recomendaciones.dto.RecomendacionUpdateRequest;
import com.agrointeligente.recomendaciones.service.RecomendacionService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recomendaciones")
public class RecomendacionController {

    private final RecomendacionService recomendacionService;

    public RecomendacionController(RecomendacionService recomendacionService) {
        this.recomendacionService = recomendacionService;
    }

    @GetMapping
    public List<RecomendacionResponse> listar() {
        return recomendacionService.findAll();
    }

    @GetMapping("/{id}")
    public RecomendacionResponse obtener(@PathVariable UUID id) {
        return recomendacionService.findById(id);
    }

    @PostMapping
    public ResponseEntity<RecomendacionResponse> crear(@Valid @RequestBody RecomendacionCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(recomendacionService.create(request));
    }

    @PutMapping("/{id}")
    public RecomendacionResponse actualizar(@PathVariable UUID id, @Valid @RequestBody RecomendacionUpdateRequest request) {
        return recomendacionService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable UUID id) {
        recomendacionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/activas")
    public List<RecomendacionResponse> activas(@RequestParam(required = false) UUID cultivoId) {
        return recomendacionService.findActivas(cultivoId);
    }

    @GetMapping("/historial")
    public List<RecomendacionResponse> historial(@RequestParam(required = false) UUID cultivoId) {
        return recomendacionService.findHistorico(cultivoId);
    }

    @PutMapping("/{id}/atender")
    public RecomendacionResponse atender(@PathVariable UUID id) {
        return recomendacionService.marcarAtendida(id);
    }

    @PutMapping("/{id}/descartar")
    public RecomendacionResponse descartar(@PathVariable UUID id) {
        return recomendacionService.descartar(id);
    }
}
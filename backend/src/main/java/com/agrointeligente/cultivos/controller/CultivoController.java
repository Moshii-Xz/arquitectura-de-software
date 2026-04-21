package com.agrointeligente.cultivos.controller;

import java.util.List;
import java.util.UUID;

import com.agrointeligente.cultivos.dto.CultivoCreateRequest;
import com.agrointeligente.cultivos.dto.CultivoResponse;
import com.agrointeligente.cultivos.dto.CultivoUpdateRequest;
import com.agrointeligente.cultivos.service.CultivoService;

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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cultivos")
public class CultivoController {

    private final CultivoService cultivoService;

    public CultivoController(CultivoService cultivoService) {
        this.cultivoService = cultivoService;
    }

    @GetMapping
    public List<CultivoResponse> listar() {
        return cultivoService.findAll();
    }

    @GetMapping("/{id}")
    public CultivoResponse obtener(@PathVariable UUID id) {
        return cultivoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<CultivoResponse> crear(@Valid @RequestBody CultivoCreateRequest request) {
        CultivoResponse response = cultivoService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public CultivoResponse actualizar(@PathVariable UUID id, @Valid @RequestBody CultivoUpdateRequest request) {
        return cultivoService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable UUID id) {
        cultivoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
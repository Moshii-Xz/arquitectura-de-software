package com.agrointeligente.insumos.controller;

import java.util.List;
import java.util.UUID;

import com.agrointeligente.insumos.dto.AplicacionInsumoCreateRequest;
import com.agrointeligente.insumos.dto.AplicacionInsumoResponse;
import com.agrointeligente.insumos.dto.AplicacionInsumoUpdateRequest;
import com.agrointeligente.insumos.dto.InsumoCreateRequest;
import com.agrointeligente.insumos.dto.InsumoResponse;
import com.agrointeligente.insumos.dto.InsumoUpdateRequest;
import com.agrointeligente.insumos.service.InsumoService;

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
@RequestMapping("/insumos")
public class InsumoController {

    private final InsumoService insumoService;

    public InsumoController(InsumoService insumoService) {
        this.insumoService = insumoService;
    }

    @GetMapping
    public List<InsumoResponse> listar() {
        return insumoService.findAll();
    }

    @GetMapping("/{id}")
    public InsumoResponse obtener(@PathVariable UUID id) {
        return insumoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<InsumoResponse> crear(@Valid @RequestBody InsumoCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(insumoService.create(request));
    }

    @PutMapping("/{id}")
    public InsumoResponse actualizar(@PathVariable UUID id, @Valid @RequestBody InsumoUpdateRequest request) {
        return insumoService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable UUID id) {
        insumoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cultivos/{cultivoId}/aplicaciones")
    public List<AplicacionInsumoResponse> listarAplicaciones(@PathVariable UUID cultivoId) {
        return insumoService.findAplicacionesByCultivo(cultivoId);
    }

    @PostMapping("/cultivos/{cultivoId}/aplicaciones")
    public ResponseEntity<AplicacionInsumoResponse> crearAplicacion(@PathVariable UUID cultivoId,
            @Valid @RequestBody AplicacionInsumoCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(insumoService.createAplicacion(cultivoId, request));
    }

    @PutMapping("/aplicaciones/{aplicacionId}")
    public AplicacionInsumoResponse actualizarAplicacion(@PathVariable UUID aplicacionId,
            @Valid @RequestBody AplicacionInsumoUpdateRequest request) {
        return insumoService.updateAplicacion(aplicacionId, request);
    }

    @DeleteMapping("/aplicaciones/{aplicacionId}")
    public ResponseEntity<Void> eliminarAplicacion(@PathVariable UUID aplicacionId) {
        insumoService.deleteAplicacion(aplicacionId);
        return ResponseEntity.noContent().build();
    }
}
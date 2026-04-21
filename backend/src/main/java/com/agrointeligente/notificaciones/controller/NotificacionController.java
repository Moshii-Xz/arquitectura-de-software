package com.agrointeligente.notificaciones.controller;

import java.util.List;
import java.util.UUID;

import com.agrointeligente.notificaciones.dto.NotificacionCreateRequest;
import com.agrointeligente.notificaciones.dto.NotificacionResponse;
import com.agrointeligente.notificaciones.service.NotificacionService;

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
@RequestMapping("/notificaciones")
public class NotificacionController {

    private final NotificacionService notificacionService;

    public NotificacionController(NotificacionService notificacionService) {
        this.notificacionService = notificacionService;
    }

    @GetMapping
    public List<NotificacionResponse> listar(@RequestParam(required = false) UUID usuarioId) {
        return usuarioId == null ? notificacionService.findAll() : notificacionService.findByUsuario(usuarioId);
    }

    @PostMapping
    public ResponseEntity<NotificacionResponse> crear(@Valid @RequestBody NotificacionCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(notificacionService.create(request));
    }

    @PutMapping("/{id}/leida")
    public NotificacionResponse marcarLeida(@PathVariable UUID id) {
        return notificacionService.marcarLeida(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable UUID id) {
        notificacionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
package com.agrointeligente.usuario.controller;

import java.util.List;
import java.util.UUID;

import com.agrointeligente.usuario.dto.CambioPasswordRequest;
import com.agrointeligente.usuario.dto.PerfilResponse;
import com.agrointeligente.usuario.dto.PerfilUpdateRequest;
import com.agrointeligente.usuario.dto.UsuarioResponse;
import com.agrointeligente.usuario.dto.UsuarioUpdateRequest;
import com.agrointeligente.usuario.service.UsuarioService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<UsuarioResponse> listar() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public UsuarioResponse obtener(@PathVariable UUID id) {
        return usuarioService.findById(id);
    }

    @PutMapping("/{id}")
    public UsuarioResponse actualizar(@PathVariable UUID id, @Valid @RequestBody UsuarioUpdateRequest request) {
        return usuarioService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable UUID id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/reactivar")
    public ResponseEntity<Void> reactivar(@PathVariable UUID id) {
        usuarioService.reactivate(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/perfil")
    public PerfilResponse obtenerPerfil(@PathVariable UUID id) {
        return usuarioService.getPerfil(id);
    }

    @PutMapping("/{id}/perfil")
    public PerfilResponse actualizarPerfil(@PathVariable UUID id, @Valid @RequestBody PerfilUpdateRequest request) {
        return usuarioService.updatePerfil(id, request);
    }

    @PutMapping("/{id}/password")
    public UsuarioResponse cambiarPassword(@PathVariable UUID id, @Valid @RequestBody CambioPasswordRequest request) {
        return usuarioService.changePassword(id, request);
    }
}
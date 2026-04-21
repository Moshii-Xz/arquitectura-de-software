package com.agrointeligente.clima.controller;

import java.util.UUID;

import com.agrointeligente.clima.dto.ClimaResponse;
import com.agrointeligente.clima.service.ClimaService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clima")
public class ClimaController {

    private final ClimaService climaService;

    public ClimaController(ClimaService climaService) {
        this.climaService = climaService;
    }

    @GetMapping
    public ClimaResponse porCoordenadas(@RequestParam(required = false) Double latitud,
            @RequestParam(required = false) Double longitud) {
        return climaService.consultarClimaPorCoordenadas(latitud, longitud);
    }

    @GetMapping("/cultivos/{cultivoId}")
    public ClimaResponse porCultivo(@PathVariable UUID cultivoId) {
        return climaService.consultarClimaDeCultivo(cultivoId);
    }
}